package grupo3p.auditorioproyect.services;

import grupo3p.auditorioproyect.entities.Category;
import grupo3p.auditorioproyect.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getById(int id){
        return categoryRepository.getById(id);
    }

    public  Category save(Category salvage){
        if(salvage.getId() == null){
            return categoryRepository.save(salvage);
        }
        return salvage;
    }

    public boolean delete(int id){
        Optional<Category> categoryOptional = categoryRepository.getById(id);
        if(categoryOptional.isPresent()){
            categoryRepository.delete(categoryOptional.get());
            return true;
        }
        return false;
    }

    public Category update(Category newData){
        if(newData.getId() != null){
            Optional<Category> oldData = categoryRepository.getById(newData.getId());
            if(oldData.isPresent()){
                Category data = oldData.get();
                if(newData.getName() != null){
                    data.setName(newData.getName());
                }
                if(newData.getDescription() != null) {
                    data.setDescription(newData.getDescription());
                }
                return categoryRepository.save(data);
            }
        }
        return newData;
    }
}
