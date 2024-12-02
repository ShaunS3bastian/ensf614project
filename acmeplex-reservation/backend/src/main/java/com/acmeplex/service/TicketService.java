package com.acmeplex.service;

import com.acmeplex.model.Ticket;
import com.acmeplex.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    /**
     * Fetch all tickets.
     *
     * @return List of all tickets
     */
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    /**
     * Fetch a ticket by its ID.
     *
     * @param ticketID Ticket ID
     * @return Ticket object or null if not found
     */
    public Ticket getTicketById(int ticketID) {
        return ticketRepository.findById(ticketID).orElse(null);
    }

    /**
     * Save or update a ticket.
     *
     * @param ticket Ticket object to save
     * @return Saved Ticket object
     */
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    /**
     * Delete a ticket by its ID.
     *
     * @param ticketID Ticket ID
     */
    public void deleteTicket(int ticketID) {
        ticketRepository.deleteById(ticketID);
    }

    /**
     * Cancel a ticket by its ID.
     *
     * @param ticketID Ticket ID to cancel
     * @return True if the cancellation is successful, false otherwise
     */
    public boolean cancelTicket(int ticketID) {
        Ticket ticket = ticketRepository.findById(ticketID).orElse(null);

        if (ticket == null) {
            return false; // Ticket not found
        }

        // Business logic: For example, allow cancellations only if certain conditions are met
        ticketRepository.deleteById(ticketID);
        return true;
    }

    /**
     * Create a new ticket.
     *
     * @param ticket Ticket details to create
     * @return Created Ticket object
     */
    public Ticket createTicket(Ticket ticket) {
        if (ticket == null || ticket.getSeatNumber() == null || ticket.getShowtimeDate() == null) {
            throw new IllegalArgumentException("Invalid ticket details.");
        }

        // Business logic for ticket creation
        return ticketRepository.save(ticket);
    }

    /**
     * Fetch all tickets for a specific user.
     *
     * @param userID User ID
     * @return List of tickets belonging to the user
     */
    public List<Ticket> getTicketsByUser(int userID) {
        return ticketRepository.findAll()
                .stream()
                .filter(ticket -> ticket.getUser() != null && ticket.getUser().getUserID() == userID)
                .collect(Collectors.toList());
    }
}
