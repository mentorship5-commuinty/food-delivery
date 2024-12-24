package food_delivery.model;

import java.io.Serializable;
import java.time.Instant;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"user\"")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password_hash", length = 60)
    private String passwordHash;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", length = 20) // Increased length to accommodate various phone formats
    private String phoneNumber;

    // Set the registrationDate in the constructor or service layer, not with @ColumnDefault
    @Column(name = "registration_date", nullable = false)
    private Instant registrationDate = Instant.now(); // Default to current timestamp

    // Set lastLogin programmatically as well
    @Column(name = "last_login")
    private Instant lastLogin;

    @Column(name = "login_type")
    private Integer loginType;

    @Column(name = "is_enabled")
    private Boolean isEnabled;

    @Column(name = "verification_code")
    private String verificationCode;


}
