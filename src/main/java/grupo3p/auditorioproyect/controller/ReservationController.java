package grupo3p.auditorioproyect.controller;

import grupo3p.auditorioproyect.entities.Reservation;
import grupo3p.auditorioproyect.entities.dto.ReportStatus;
import grupo3p.auditorioproyect.entities.dto.TopClients;
import grupo3p.auditorioproyect.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getById(@PathVariable("id") int id){
        return reservationService.getById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation salvage){
        return reservationService.save(salvage);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation newData){
        return reservationService.update(newData);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return reservationService.delete(id);
    }

    @GetMapping("/report-dates/{dateA}/{dateB}")
    public List<Reservation> getByDates(@PathVariable("dateA")String date1, @PathVariable("dateB")String date2){
        return reservationService.getReservationsByPeriod(date1, date2);
    }

    @GetMapping("/report-status")
    public ReportStatus getByStatus(){
        return reservationService.getReportStatus();
    }

    @GetMapping("/report-clients")
    public List<TopClients> getTopClient(){
        return reservationService.getTopClient();
    }
}
