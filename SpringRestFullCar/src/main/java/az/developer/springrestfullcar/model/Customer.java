package az.developer.springrestfullcar.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@RequiredArgsConstructor
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "phone")
    private String phone;


    public Customer(int customerId) {
    }
}
