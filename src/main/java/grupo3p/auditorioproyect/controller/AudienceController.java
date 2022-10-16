package grupo3p.auditorioproyect.controller;

import grupo3p.auditorioproyect.entities.Audience;
import grupo3p.auditorioproyect.services.AudienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Audience")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AudienceController {

    @Autowired
    private AudienceService audienceService;

    @GetMapping("/all")
    public List<Audience> getAll(){
        return audienceService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Audience save(@RequestBody Audience salvage){
          return audienceService.save(salvage);
    }
}
