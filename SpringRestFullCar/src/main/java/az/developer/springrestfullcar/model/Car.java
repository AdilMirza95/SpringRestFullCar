package az.developer.springrestfullcar.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name="car")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private int carId;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private int year;

    @Column(name = "dayofprice")
    private int dayOfPrice;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", dayOfPrice=" + dayOfPrice +
                ", category=" + category +
                ", customer=" + customer +
                '}';
    }
}

