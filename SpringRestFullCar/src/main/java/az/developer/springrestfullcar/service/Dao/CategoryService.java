package az.developer.springrestfullcar.service.Dao;

import az.developer.springrestfullcar.rest.model.request.CategoryDto;
import az.developer.springrestfullcar.rest.model.response.CategoryResponse;

public interface CategoryService {
    CategoryResponse getAllCategory();
    CategoryDto getCategoryById(int id);
    CategoryResponse getCategoryByCategoryName(String categoryName);
    void insert(CategoryDto categoryDto);
    void updatePut(int id,CategoryDto categoryDto);
    void updatePatch(int id,CategoryDto categoryDto);
    void deleteCategoryById(int id);

}
