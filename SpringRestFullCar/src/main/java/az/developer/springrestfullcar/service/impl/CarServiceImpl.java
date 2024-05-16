package az.developer.springrestfullcar.service.impl;

import az.developer.springrestfullcar.model.Car;
import az.developer.springrestfullcar.model.Category;
import az.developer.springrestfullcar.model.Customer;
import az.developer.springrestfullcar.repository.CarRepository;
import az.developer.springrestfullcar.rest.model.request.CarDto;
import az.developer.springrestfullcar.rest.model.response.CarResponse;
import az.developer.springrestfullcar.service.Dao.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public CarResponse getAllCars() {
        List<Car> carList = carRepository.findAll();
        List<CarDto> carDtoList = new ArrayList<>();

        for (Car c : carList) {
            carDtoList.add(convertDto(c));
        }
        return new CarResponse(carDtoList);
    }

    @Override
    public CarDto getCarById(int id) {
        Car car = carRepository.findById(id).orElseThrow();
        return convertDto(car);
    }

    @Override
    public CarResponse getCarByBrand(String brand) {
        List<Car> carList = carRepository.findCarByBrand(brand);
        List<CarDto> carDtoList = new ArrayList<>();

        for (Car c : carList) {
            carDtoList.add(convertDto(c));
        }
        return new CarResponse(carDtoList);
    }

    @Override
    public void insert(CarDto carDto) {
        Car c = new Car();
        c.setBrand(carDto.getBrand());
        c.setModel(carDto.getModel());
        c.setDayOfPrice(carDto.getDayOfPrice());
        c.setYear(carDto.getYear());

        if(carDto.getCategory() != null) {
           Category category = CategoryServiceImpl.convertEntityCategory(carDto.getCategory());
           c.setCategory(category);
        }
        if(carDto.getCustomer() != null) {
           Customer customer = CustomerServiceImpl.convertEntity(carDto.getCustomer());
            c.setCustomer(customer);
        }
        carRepository.save(c);
    }

    @Override
    public void updatePut(int id, CarDto carDto) {
        Car c = carRepository.findById(id).orElseThrow(() -> new NullPointerException());
        c.setBrand(carDto.getBrand());
        c.setModel(carDto.getModel());
        c.setYear(carDto.getYear());
        c.setDayOfPrice(carDto.getDayOfPrice());
        carRepository.save(c);
    }

    @Override
    public void updatePatch(int id, CarDto carDto) {
        Car c = carRepository.findById(id).orElseThrow(() -> new NullPointerException());
        if (carDto.getBrand() != null)
            c.setBrand(carDto.getBrand());
        if (carDto.getModel() != null)
            c.setModel(carDto.getModel());
        if (carDto.getYear() != null)
            c.setYear(carDto.getYear());
        if (carDto.getDayOfPrice() != null)
            c.setDayOfPrice(carDto.getDayOfPrice());
        carRepository.save(c);
    }

    @Transactional
    @Override
    public void deleteCarByCarId(int id) {

        carRepository.deleteById(id);
    }


    public static CarDto convertDto(Car car) {
        CarDto.CarDtoBuilder carDtoBuilder = CarDto.builder()
                .carId(car.getCarId())
                .brand(car.getBrand())
                .model(car.getModel())
                .year(car.getYear())
                .dayOfPrice(car.getDayOfPrice());

        if (car.getCategory() != null) {
          carDtoBuilder.category(CategoryServiceImpl.convertDto(car.getCategory()));
        }

        if (car.getCustomer() != null) {
            carDtoBuilder.customer(CustomerServiceImpl.convertDto(car.getCustomer()));
        }

        return carDtoBuilder.build();
    }
    public static Car convertCar(CarDto carDto) {
         Car.CarBuilder carBuilder =  Car.builder()
                .carId(carDto.getCarId())
                .brand(carDto.getBrand())
                .model(carDto.getModel())
                .year(carDto.getYear())
                .dayOfPrice(carDto.getDayOfPrice());

        if (carDto.getCategory() != null) {
            carBuilder.category(CategoryServiceImpl.convertEntityCategory(carDto.getCategory()));
        }

        if (carDto.getCustomer() != null) {
            carBuilder.customer(CustomerServiceImpl.convertEntity(carDto.getCustomer()));
        }

        return carBuilder.build();
    }



}

