package az.developer.springrestfullcar.rest.model.response;

import az.developer.springrestfullcar.model.Category;
import az.developer.springrestfullcar.rest.model.request.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class CategoryResponse {
    private List<CategoryDto> allCategory;


}
