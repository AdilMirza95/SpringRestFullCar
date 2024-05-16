package az.developer.springrestfullcar.rest.model.response;

import az.developer.springrestfullcar.rest.model.request.CustomerDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CustomerResponse {

    private List<CustomerDto> allCustomer;
}
