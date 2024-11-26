package com.acmeplex.controller;

import com.acmeplex.model.Ticket;
import com.acmeplex.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/book")
    public ResponseEntity<Ticket> bookTicket(@RequestBody Ticket ticketRequest) {
        Ticket ticket = ticketService.bookTicket(
                ticketRequest.getUser().getId(),
                ticketRequest.getShowtime().getId(),
                ticketRequest.getSeat().getId(),
                ticketRequest.getPrice()
        );
        return ResponseEntity.ok(ticket);
    }

    @PostMapping("/cancel/{ticketId}")
    public ResponseEntity<?> cancelTicket(@PathVariable Long ticketId, @RequestParam boolean isRegisteredUser) {
        try {
            ticketService.cancelTicket(ticketId, isRegisteredUser);
            return ResponseEntity.ok("Ticket cancelled successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Ticket>> getUserTickets(@PathVariable Long userId) {
        return ResponseEntity.ok(ticketService.getUserTickets(userId));
    }
}
