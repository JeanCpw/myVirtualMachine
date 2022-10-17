package grupo3p.auditorioproyect.repository;

import grupo3p.auditorioproyect.entities.Admin;
import grupo3p.auditorioproyect.repository.crud.AdminCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {

    @Autowired
    private AdminCrudRepository adminCrudRepository;

    public List<Admin> getAll(){
        return (List<Admin>) adminCrudRepository.findAll();
    }

    public Optional<Admin> getById(int id){
        return adminCrudRepository.findById(String.valueOf(id));
    }

    public  Admin save(Admin salvage){
        return adminCrudRepository.save(salvage);
    }

    public void delete(Admin endAdmin){
        adminCrudRepository.delete(endAdmin);
    }
}
