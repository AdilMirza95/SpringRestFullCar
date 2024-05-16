package az.developer.springrestfullcar.rest.model.request;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class CarDto {
    private Integer carId;
    private String brand;
    private String model;
    private Integer year;
    private Integer dayOfPrice;
    private CategoryDto category;
    private CustomerDto customer;


}

