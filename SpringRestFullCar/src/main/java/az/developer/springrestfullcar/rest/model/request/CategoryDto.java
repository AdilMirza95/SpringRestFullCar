package az.developer.springrestfullcar.rest.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {

    private Integer categoryId;
    private String categoryName;

}
