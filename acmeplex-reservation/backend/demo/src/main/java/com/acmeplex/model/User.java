Package com.acmeplex.model

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password; // Encrypted
    private boolean isRegisteredUser;

    private String address; // Optional for ordinary users
    private String creditCardInfo; // Optional for ordinary users

    private LocalDateTime accountExpiry; // For Registered Users

    // Getters and Setters
}
