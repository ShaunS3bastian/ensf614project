Package com.acmeplex.controller

@RestController
@RequestMapping("/api/seats")
public class SeatController {
    @Autowired
    private SeatRepository seatRepository;

    @GetMapping("/showtime/{showtimeId}")
    public ResponseEntity<List<Seat>> getAvailableSeats(@PathVariable Long showtimeId) {
        return ResponseEntity.ok(seatRepository.findByShowtimeIdAndIsReserved(showtimeId, false));
    }
}
