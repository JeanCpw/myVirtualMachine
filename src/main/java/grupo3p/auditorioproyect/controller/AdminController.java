package grupo3p.auditorioproyect.controller;

import grupo3p.auditorioproyect.entities.Admin;
import grupo3p.auditorioproyect.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<Admin> getAll(){
        return adminService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Admin> getById(@PathVariable("id") int id){
        return adminService.getById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin salvage){
        return adminService.save(salvage);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin newData){
        return adminService.update(newData);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return adminService.delete(id);
    }
}
