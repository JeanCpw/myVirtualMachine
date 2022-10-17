package grupo3p.auditorioproyect.repository;

import grupo3p.auditorioproyect.entities.Category;
import grupo3p.auditorioproyect.repository.crud.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
   private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll(){
        return (List<Category>)categoryCrudRepository.findAll();
    }

    public Optional<Category> getById(int id){
        return categoryCrudRepository.findById(id);
    }

    public Category save(Category salvage){
        return categoryCrudRepository.save(salvage);
    }

    public void delete(Category endCategory){
        categoryCrudRepository.delete(endCategory);
    }
}
