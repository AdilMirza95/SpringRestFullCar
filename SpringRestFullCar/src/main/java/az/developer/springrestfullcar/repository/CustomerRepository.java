package az.developer.springrestfullcar.repository;

import az.developer.springrestfullcar.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    List<Customer> findCustomerByfullName (String fullName);

}
