package grupo3p.auditorioproyect.services;

import grupo3p.auditorioproyect.entities.Reservation;
import grupo3p.auditorioproyect.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Reservation save(Reservation salvage){
        return reservationRepository.save(salvage);
    }
}
