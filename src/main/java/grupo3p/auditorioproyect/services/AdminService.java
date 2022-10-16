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

    public Admin save(Admin salvage){ return adminRepository.save(salvage); }
}
