Package com.acmeplex.model

@Entity
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime time;
    private String cinema;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private int totalSeats;
    private int reservedSeats;

    // Getters and Setters
}
