package food_delivery.model;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Etity
@Table(name="USER_TYPE")
public class UserType{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_TYPE_ID")
    private Long id;

    @Column(name = "USER_TYPE_NAME")
    private String userTypeName;

}