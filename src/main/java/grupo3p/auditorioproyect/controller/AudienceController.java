package grupo3p.auditorioproyect.controller;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import grupo3p.auditorioproyect.entities.Audience;
import grupo3p.auditorioproyect.services.AudienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Audience")
public class AudienceController {

    @Autowired
    private AudienceService audienceService;

    @GetMapping("/all")
    public List<Audience> getAll(){
        return audienceService.getAll();
    }

    @PostMapping("/save")
    public Audience save(@RequestBody Audience salvage){
          return audienceService.save(salvage);
    }
}
