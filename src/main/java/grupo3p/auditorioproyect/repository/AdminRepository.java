package grupo3p.auditorioproyect.repository;

import grupo3p.auditorioproyect.entities.Admin;
import grupo3p.auditorioproyect.repository.crud.AdminCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdminRepository {

    @Autowired
    private AdminCrudRepository adminCrudRepository;

    public List<Admin> getAll(){
        return (List<Admin>) adminCrudRepository.findAll();
    }

    public  Admin save(Admin salvage){
        return adminCrudRepository.save(salvage);
    }
}
