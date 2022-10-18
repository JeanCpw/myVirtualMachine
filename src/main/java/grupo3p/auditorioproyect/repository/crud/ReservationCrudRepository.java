package grupo3p.auditorioproyect.repository.crud;

import grupo3p.auditorioproyect.entities.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {

    @Query("SELECT info.client, COUNT(info.client) FROM Reservation AS info GROUP BY info.client ORDER BY COUNT (info.client) DESC")
    public List<Object[]> getTopClients();

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date info1, Date info2);

    public List<Reservation> findAllByStatus(String status);
}
