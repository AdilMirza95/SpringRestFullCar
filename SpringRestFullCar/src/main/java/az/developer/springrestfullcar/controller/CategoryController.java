package az.developer.springrestfullcar.controller;

import az.developer.springrestfullcar.rest.model.request.CategoryDto;
import az.developer.springrestfullcar.rest.model.response.CategoryResponse;
import az.developer.springrestfullcar.service.Dao.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/all")
    public CategoryResponse getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryById(@PathVariable("id") int id){
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/search")
    public CategoryResponse getCategoryByCategoryName(String categoryName){
        return categoryService.getCategoryByCategoryName(categoryName);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody CategoryDto categoryDto){
        categoryService.insert(categoryDto);
    }

    @PutMapping("/{id}")
    public void updatePut(@PathVariable("id")int id,@RequestBody CategoryDto categoryDto){
        categoryService.updatePut(id,categoryDto);
    }

    @PatchMapping("/{id}")
    public void updatePatch(@PathVariable("id")int id,@RequestBody CategoryDto categoryDto){
        categoryService.updatePatch(id,categoryDto);
    }
    @Transactional
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") int id){

        categoryService.deleteCategoryById(id);
    }

}
