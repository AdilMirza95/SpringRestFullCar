package az.developer.springrestfullcar.service.Dao;

import az.developer.springrestfullcar.rest.model.request.CarDto;
import az.developer.springrestfullcar.rest.model.response.CarResponse;

public interface CarService {
    CarResponse getAllCars();
    CarDto getCarById(int id);
    CarResponse getCarByBrand(String brand);
    void insert(CarDto carDto);
    void updatePut(int id,CarDto carDto);
    void updatePatch(int id,CarDto carDto);
    void deleteCarByCarId(int id);




}
