package grupo3p.auditorioproyect.services;

import grupo3p.auditorioproyect.entities.Score;
import grupo3p.auditorioproyect.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }

    public Optional<Score> getById(int id){
        return scoreRepository.getById(id);
    }

    public Score save(Score salvage){
        if(salvage.getIdScore() == null){
            return scoreRepository.save(salvage);
        }
        return salvage;
    }

    public boolean delete(int id){
        Optional<Score> scoreOptional = scoreRepository.getById(id);
        if(scoreOptional.isPresent()){
            scoreRepository.delete(scoreOptional.get());
            return true;
        }
        return false;
    }

    public Score update(Score newData){
        if(newData.getIdScore() != null){
            Optional<Score> oldData = scoreRepository.getById(newData.getIdScore());
            if(oldData.isPresent()){
                Score data = oldData.get();
                if(newData.getScore() != null){
                    data.setScore(newData.getScore());
                }
                if(newData.getMessageText() != null){
                    data.setMessageText(newData.getMessageText());
                }
                return scoreRepository.save(data);
            }
        }
        return newData;
    }
}
