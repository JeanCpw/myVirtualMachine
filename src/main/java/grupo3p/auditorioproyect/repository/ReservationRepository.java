package grupo3p.auditorioproyect.repository;

import grupo3p.auditorioproyect.entities.Reservation;
import grupo3p.auditorioproyect.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getById(int id){
       return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation salvage){
        return reservationCrudRepository.save(salvage);
    }

    public void delete(Reservation endReservation){
        reservationCrudRepository.delete(endReservation);
    }
}
