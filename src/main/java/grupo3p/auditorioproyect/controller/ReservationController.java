package grupo3p.auditorioproyect.controller;

import grupo3p.auditorioproyect.entities.Reservation;
import grupo3p.auditorioproyect.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }

    @PostMapping("/save")
    public Reservation save(@RequestBody Reservation salvage){
        return reservationService.save(salvage);
    }
}
