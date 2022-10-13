package grupo3p.auditorioproyect.controller;

import grupo3p.auditorioproyect.entities.Admin;
import grupo3p.auditorioproyect.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<Admin> getAll(){
        return adminService.getAll();
    }

    @PostMapping("/save")
    public Admin save(@RequestBody Admin salvage){
        return adminService.save(salvage);
    }
}
