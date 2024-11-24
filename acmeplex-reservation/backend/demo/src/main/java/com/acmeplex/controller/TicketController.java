Package com.acmeplex.controller

@PostMapping("/book")
public ResponseEntity<?> bookTickets(@RequestBody TicketBookingRequest request) {
    ticketService.bookTickets(request.getShowtimeId(), request.getSeatIds());
    return ResponseEntity.ok("Tickets booked successfully!");
}
