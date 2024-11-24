Package com.acmeplex.

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String genre;
    private String description;
    private int duration; // In minutes

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Showtime> showtimes;

    // Getters and Setters
}
