package az.developer.springrestfullcar.repository;

import az.developer.springrestfullcar.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {

     List<Car> findCarByBrand(String brand);
}
