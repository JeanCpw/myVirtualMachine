package grupo3p.auditorioproyect.services;

import grupo3p.auditorioproyect.entities.Score;
import grupo3p.auditorioproyect.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }

    public Score save(Score salvage){
        return scoreRepository.save(salvage);
    }
}
