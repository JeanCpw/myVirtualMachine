package grupo3p.auditorioproyect.controller;

import grupo3p.auditorioproyect.entities.Score;
import grupo3p.auditorioproyect.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
    public List<Score> getAll(){
        return scoreService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Score> getById(@PathVariable("id") int id){
        return scoreService.getById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score Save(@RequestBody Score salvage){
        return scoreService.save(salvage);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update(@RequestBody Score newData){
        return scoreService.update(newData);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return scoreService.delete(id);
    }
}
