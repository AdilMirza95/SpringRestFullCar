package az.developer.springrestfullcar.rest.model.response;

import az.developer.springrestfullcar.rest.model.request.CarDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class CarResponse {
    private List<CarDto> allCars;

}
