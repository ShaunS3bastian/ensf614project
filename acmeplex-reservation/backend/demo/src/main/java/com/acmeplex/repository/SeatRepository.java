Package com.acmeplex.repository

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByShowtimeIdAndIsReserved(Long showtimeId, boolean isReserved);
}
