//package food_delivery.model;
//
//import java.util.List;
//
//import javax.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name="USER_TYPE")
//public class UserType{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "USER_TYPE_ID")
//    private Long id;
//
//    @Column(name = "USER_TYPE_NAME")
//    private String userTypeName;
//
//    @OneToMany(mappedBy ="userType" , fetch = FetchType.LAZY)
//    private List<User> users;
//
//}