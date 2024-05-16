package az.developer.springrestfullcar.service.impl;

import az.developer.springrestfullcar.model.Category;
import az.developer.springrestfullcar.repository.CategoryRepository;
import az.developer.springrestfullcar.rest.model.request.CategoryDto;
import az.developer.springrestfullcar.rest.model.response.CategoryResponse;
import az.developer.springrestfullcar.service.Dao.CategoryService;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponse getAllCategory() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDto> categoryDtoList = new ArrayList<>();

        for (Category c: categoryList) {
            categoryDtoList.add(convertDto(c));
        }
        return new CategoryResponse(categoryDtoList);
    }

    @Override
    public CategoryDto getCategoryById(int id) {
       Category category =  categoryRepository.findById(id).orElseThrow(() -> new NullPointerException());
       return convertDto(category);
    }

    @Override
    public CategoryResponse getCategoryByCategoryName(String categoryName) {
        List<Category> categoryList = categoryRepository.findCategoryByCategoryName(categoryName);
                List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (Category category: categoryList){
            categoryDtoList.add(convertDto(category));
        }
        return new CategoryResponse(categoryDtoList);
    }


    @Override
    public void insert(CategoryDto categoryDto) {
        Category category = new Category();
        category.setCategoryName(categoryDto.getCategoryName());
        categoryRepository.save(category);
    }

    @Override
    public void updatePut(int id,CategoryDto categoryDto) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new NullPointerException());
        category.setCategoryName(categoryDto.getCategoryName());
        categoryRepository.save(category);
    }

    @Override
    public void updatePatch(int id,CategoryDto categoryDto) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new NullPointerException());
        if (categoryDto.getCategoryName() != null)
        category.setCategoryName(categoryDto.getCategoryName());
        categoryRepository.save(category);
    }

    @Transactional
    @Override
    public void deleteCategoryById(int id) {

        categoryRepository.deleteById(id);
    }


    public static CategoryDto convertDto(Category category){
       return CategoryDto.builder()
                .categoryId(category.getCategoryId())
                .categoryName(category.getCategoryName())
                .build();
    }

    public static Category convertEntityCategory(CategoryDto categoryDto){
        return Category.builder()
                .categoryId(categoryDto.getCategoryId())
                .categoryName(categoryDto.getCategoryName())
                .build();
    }


}
