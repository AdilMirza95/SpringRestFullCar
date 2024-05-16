package az.developer.springrestfullcar.rest.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerDto{

    private Integer customerId;
    private String fullName;
    private String phone;


}
