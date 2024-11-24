Package com.acmeplex.model

@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatNumber;
    private boolean isReserved;

    @ManyToOne
    @JoinColumn(name = "showtime_id")
    private Showtime showtime;

    // Getters and Setters
}