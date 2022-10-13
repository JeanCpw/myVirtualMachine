package grupo3p.auditorioproyect.controller;

import grupo3p.auditorioproyect.entities.Category;
import grupo3p.auditorioproyect.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @PostMapping("/save")
    public Category save(@RequestBody Category salvage){
        return categoryService.save(salvage);
    }
}
