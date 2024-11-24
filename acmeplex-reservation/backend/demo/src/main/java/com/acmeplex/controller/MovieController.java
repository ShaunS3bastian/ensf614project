Package com.acmeplex.controller

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping
    public List<Movie> listMovies() {
        return movieRepository.findAll();
    }
}