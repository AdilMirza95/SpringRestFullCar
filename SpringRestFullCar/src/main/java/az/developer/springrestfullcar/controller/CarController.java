package az.developer.springrestfullcar.controller;

import az.developer.springrestfullcar.rest.model.request.CarDto;
import az.developer.springrestfullcar.rest.model.response.CarResponse;
import az.developer.springrestfullcar.service.Dao.CarService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("cars")
public class CarController {

    private final CarService carService;

    @GetMapping("/all")
    public CarResponse getAllCars(){
       return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public CarDto getCarById(@PathVariable("id") int id){
        return carService.getCarById(id);
    }

    @GetMapping("/search")
    public CarResponse getCarByBrand(@RequestParam("brand") String brand){
       return carService.getCarByBrand(brand);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody CarDto carDto){
        carService.insert(carDto);
    }

    @PutMapping("/{id}")
    public void updatePut(@PathVariable ("id") int id,@RequestBody CarDto carDto){
          carService.updatePut(id,carDto);
    }

    @PatchMapping("/{id}")
    public void updatePatch(@PathVariable ("id") int id,@RequestBody CarDto carDto){
        carService.updatePatch(id, carDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable ("id") int id){
        carService.deleteCarByCarId(id);
    }



}
