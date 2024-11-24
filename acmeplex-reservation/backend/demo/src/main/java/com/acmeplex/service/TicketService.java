Package com.acmeplex.service

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public void cancelTicket(Long ticketId, User user) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found"));

        // Validate cancellation timeframe (72 hours before showtime)
        if (ticket.getShowtime().getTime().isBefore(LocalDateTime.now().plusHours(72))) {
            throw new IllegalArgumentException("Cancellation is only allowed up to 72 hours before showtime.");
        }

        ticket.setCancelled(true);

        // Calculate refund
        double refundAmount = ticket.getPrice();
        if (!user.isRegisteredUser()) {
            refundAmount *= 0.85; // Apply 15% admin fee
        }
        ticket.setRefunded(true);

        ticketRepository.save(ticket);

        // Logic to process refund (external payment service integration)
        processRefund(refundAmount, user.getCreditCardInfo());
    }

    private void processRefund(double amount, String creditCardInfo) {
        // Example: Stripe refund logic
        // Stripe.apiKey = "your-stripe-secret-key";
        // Refund.create(Map.of("amount", amountInCents, "source", creditCardInfo));
    }
}

