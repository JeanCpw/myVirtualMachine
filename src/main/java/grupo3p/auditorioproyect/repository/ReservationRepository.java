package grupo3p.auditorioproyect.repository;

import grupo3p.auditorioproyect.entities.Reservation;
import grupo3p.auditorioproyect.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Reservation save(Reservation salvage){
        return reservationCrudRepository.save(salvage);
    }
}
