package grupo3p.auditorioproyect.services;

import grupo3p.auditorioproyect.entities.Reservation;
import grupo3p.auditorioproyect.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getById(int id){
        return reservationRepository.getById(id);
    }

    public Reservation save(Reservation salvage){
        if(salvage.getIdReservation() == null){
            return reservationRepository.save(salvage);
        }
        return salvage;
    }

    public boolean delete(int id){
        Optional<Reservation> reservationOptional = reservationRepository.getById(id);
        if(reservationOptional.isPresent()){
            reservationRepository.delete(reservationOptional.get());
            return true;
        }
        return false;
    }

    public Reservation update(Reservation newData){
        if(newData.getIdReservation() != null){
            Optional<Reservation> oldData = reservationRepository.getById(newData.getIdReservation());
            if(oldData.isPresent()){
                Reservation data = oldData.get();
                if(newData.getStartDate() != null){
                    data.setStartDate(newData.getStartDate());
                }
                if(newData.getDevolutionDate() != null){
                    data.setDevolutionDate(newData.getDevolutionDate());
                }
                if(newData.getStatus() != null){
                    data.setStatus(newData.getStatus());
                }
            }
        }
        return newData;
    }
}
