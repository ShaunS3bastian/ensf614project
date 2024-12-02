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

    // Get all tickets
    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    // Get tickets for a specific user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Ticket>> getTicketsByUser(@PathVariable int userId) {
        return ResponseEntity.ok(ticketService.getTicketsByUser(userId));
    }

    // Get ticket by ID
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable int id) {
        return ResponseEntity.ok(ticketService.getTicketById(id));
    }

    // Create a new ticket
    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        return ResponseEntity.ok(ticketService.createTicket(ticket));
    }

    // Cancel a ticket
    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelTicket(@PathVariable int id) {
        boolean isCancelled = ticketService.cancelTicket(id);
        if (isCancelled) {
            return ResponseEntity.ok("Ticket canceled successfully.");
        } else {
            return ResponseEntity.badRequest().body("Cancellation failed. Please ensure the cancellation policy is met.");
        }
    }
}
