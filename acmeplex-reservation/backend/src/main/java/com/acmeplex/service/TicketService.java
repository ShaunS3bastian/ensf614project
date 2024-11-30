package com.acmeplex.service;

import com.acmeplex.model.Seat;
import com.acmeplex.model.Showtime;
import com.acmeplex.model.Ticket;
import com.acmeplex.model.PaymentRequest;
import com.acmeplex.repository.SeatRepository;
import com.acmeplex.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private PaymentService paymentService;

    public Ticket bookTicket(Long userId, Long showtimeId, Long seatId, PaymentRequest paymentRequest) {
        // Step 1: Process Payment
        if (!paymentService.processPayment(paymentRequest)) {
            throw new IllegalArgumentException("Payment failed. Please try again.");
        }

        // Step 2: Validate and reserve the seat
        Seat seat = seatRepository.findById(seatId)
                .orElseThrow(() -> new IllegalArgumentException("Seat not found."));
        if (seat.isReserved()) {
            throw new IllegalArgumentException("Seat is already reserved.");
        }

        seat.setReserved(true);
        seatRepository.save(seat);

        // Step 3: Create the ticket
        Ticket ticket = new Ticket();
        ticket.setUser(new User(userId)); // Minimal User instance with ID
        ticket.setShowtime(new Showtime(showtimeId)); // Minimal Showtime instance with ID
        ticket.setSeat(seat);
        ticket.setPrice(paymentRequest.getAmount() / 100.0); // Convert cents to dollars
        ticket.setCancelled(false);

        return ticketRepository.save(ticket);
    }

    public void cancelTicket(Long ticketId, boolean isRegisteredUser) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found."));
        if (ticket.getShowtime().getTime().isBefore(LocalDateTime.now().plusHours(72))) {
            throw new IllegalArgumentException("Tickets can only be canceled up to 72 hours before the showtime.");
        }

        ticket.setCancelled(true);
        double refundAmount = isRegisteredUser ? ticket.getPrice() : ticket.getPrice() * 0.85; // Deduct 15% for ordinary users
        ticketRepository.save(ticket);

        // Process refund
        paymentService.processRefund(refundAmount, "mock-transaction-id");
        System.out.println("Refund of $" + refundAmount + " processed.");
    }

    public List<Ticket> getUserTickets(Long userId) {
        return ticketRepository.findByUserId(userId);
    }
}
