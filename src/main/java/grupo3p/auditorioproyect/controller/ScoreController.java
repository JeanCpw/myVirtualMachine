package grupo3p.auditorioproyect.controller;

import grupo3p.auditorioproyect.entities.Score;
import grupo3p.auditorioproyect.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
    public List<Score> getAll(){
        return scoreService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score Save(@RequestBody Score salvage){
        return scoreService.save(salvage);
    }
}
