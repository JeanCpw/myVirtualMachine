package grupo3p.auditorioproyect.services;

import grupo3p.auditorioproyect.entities.Admin;
import grupo3p.auditorioproyect.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll(){
        return adminRepository.getAll();
    }

    public Optional<Admin> getById(int id){
        return adminRepository.getById(id);
    }

    public Admin save(Admin salvage){
        if(salvage.getIdAdmin() == null){
            return adminRepository.save(salvage);
        }
        return salvage;
    }

    public boolean delete(int id){
        Optional<Admin> adminOptional = adminRepository.getById(id);
        if(adminOptional.isPresent()){
            adminRepository.delete(adminOptional.get());
            return true;
        }
        return false;
    }

    public Admin update(Admin newData){
        if(newData.getIdAdmin() != null){
            Optional<Admin> oldData = adminRepository.getById(newData.getIdAdmin());
            if(oldData.isPresent()){
                Admin data = oldData.get();
                if(newData.getName() != null){
                    data.setName(newData.getName());
                }
                if(newData.getPassword() != null){
                    data.setPassword(newData.getPassword());
                }
                if(newData.getEmail() != null){
                    data.setEmail(newData.getEmail());
                }
                return adminRepository.save(data);
            }
        }
        return newData;
    }

}
