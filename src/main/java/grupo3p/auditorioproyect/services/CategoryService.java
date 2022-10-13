package grupo3p.auditorioproyect.services;

import grupo3p.auditorioproyect.entities.Category;
import grupo3p.auditorioproyect.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public  Category save(Category salvage){
        return categoryRepository.save(salvage);
    }
}
