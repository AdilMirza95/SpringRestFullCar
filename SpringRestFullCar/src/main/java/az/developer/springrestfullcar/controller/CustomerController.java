package az.developer.springrestfullcar.controller;

import az.developer.springrestfullcar.rest.model.request.CustomerDto;
import az.developer.springrestfullcar.rest.model.response.CustomerResponse;
import az.developer.springrestfullcar.service.impl.CustomerServiceImpl;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerServiceImpl customerService;

    @GetMapping("/all")
    public CustomerResponse getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable("id") int id){
        return  customerService.getCustomerById(id);
    }

    @GetMapping("search")
    public CustomerResponse getCustomerByName(String fullName){
       return customerService.getCustomerByfullName(fullName);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody CustomerDto customerDto){

        customerService.insert(customerDto);
    }

    @PutMapping("{id}")
    public void updatePut(@PathVariable("id") int id,@RequestBody CustomerDto customerDto){

        customerService.updatePut(id,customerDto);
    }

    @PatchMapping("{id}")
    public void updatePatch(@PathVariable("id") int id,@RequestBody CustomerDto customerDto){

        customerService.updatePatch(id,customerDto);
    }


    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable("id") int customerId){
         customerService.deleteCustomer(customerId);;
    }
}
