package az.developer.springrestfullcar.service.Dao;


import az.developer.springrestfullcar.rest.model.request.CustomerDto;
import az.developer.springrestfullcar.rest.model.response.CustomerResponse;

public interface CustomerService {
    CustomerResponse getAllCustomers();
    CustomerDto getCustomerById(int id);
    CustomerResponse getCustomerByfullName(String fullName);
    void insert(CustomerDto customerDto);
    void updatePut(int id,CustomerDto customerDto);
    void updatePatch(int id,CustomerDto customerDto);
    void deleteCustomer(int id);

}
