Package com.acmeplex.repository

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByUserIdAndIsCancelledFalse(Long userId);
}
