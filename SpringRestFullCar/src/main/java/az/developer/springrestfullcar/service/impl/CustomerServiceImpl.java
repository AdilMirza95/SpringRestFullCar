package az.developer.springrestfullcar.service.impl;
import az.developer.springrestfullcar.model.Customer;
import az.developer.springrestfullcar.repository.CustomerRepository;
import az.developer.springrestfullcar.rest.model.request.CustomerDto;
import az.developer.springrestfullcar.rest.model.response.CustomerResponse;
import az.developer.springrestfullcar.service.Dao.CustomerService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;


    @Override
    public CustomerResponse getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDto> customerDtoList = new ArrayList<>();

        for (Customer cust : customerList){
            customerDtoList.add(convertDto(cust));
        }
        return  new CustomerResponse(customerDtoList);
    }

    @Override
    public CustomerDto getCustomerById(int id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return convertDto(customer);
    }

    @Override
    public CustomerResponse getCustomerByfullName(String fullName) {
        List<Customer> customerList = customerRepository.findCustomerByfullName(fullName);
        if (customerList == null){
            return new CustomerResponse(Collections.emptyList());
        }
        List<CustomerDto> customerDtoList = new ArrayList<>();
        for (Customer customer: customerList){
            customerDtoList.add(convertDto(customer));
        }

        return new CustomerResponse(customerDtoList);
    }

    @Override
    public void insert(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setFullName(customerDto.getFullName());
        customer.setPhone(customerDto.getPhone());
        customerRepository.save(customer);
    }

    @Override
    public void updatePut(int id, CustomerDto customerDto) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        customer.setFullName(customerDto.getFullName());
        customer.setPhone(customerDto.getPhone());
        customerRepository.save(customer);
    }

    @Override
    public void updatePatch(int id, CustomerDto customerDto) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        if(customerDto.getFullName() != null)
        customer.setFullName(customerDto.getFullName());
        if(customerDto.getPhone() != null)
        customer.setPhone(customerDto.getPhone());
        customerRepository.save(customer);

    }

    @Override
    @Transactional
    public void deleteCustomer(int customerId) {
        Customer customer = customerRepository.findById(customerId)
        .orElseThrow(() -> new RuntimeException("Musteri tapilmadi"));
        customerRepository.delete(customer);
    }

    public static CustomerDto convertDto(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerId(customer.getCustomerId());
        customerDto.setFullName(customer.getFullName());
        customerDto.setPhone(customer.getPhone());
        return customerDto;
    }
    public static Customer convertEntity(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setCustomerId(customerDto.getCustomerId());
        customer.setFullName(customerDto.getFullName());
        customer.setPhone(customerDto.getPhone());
        return customer;
    }


}
