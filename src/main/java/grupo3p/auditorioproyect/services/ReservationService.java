package grupo3p.auditorioproyect.services;

import grupo3p.auditorioproyect.entities.Client;
import grupo3p.auditorioproyect.entities.Reservation;
import grupo3p.auditorioproyect.entities.dto.ReportStatus;
import grupo3p.auditorioproyect.entities.dto.TopClients;
import grupo3p.auditorioproyect.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public List<Reservation> getReservationsByPeriod(String dateA, String dateB){

        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date firstDate = new Date();
        Date secondDate = new Date();

        try{
            firstDate = parser.parse(dateA);
            secondDate = parser.parse(dateB);
        }catch(ParseException parseException){
            parseException.printStackTrace();
        }
        if(firstDate.before(secondDate)){
            return reservationRepository.getReports(firstDate, secondDate);
        }else{
            return new ArrayList<Reservation>();
        }
    }

    public ReportStatus getReportStatus(){
        List<Reservation> completed = reservationRepository.getStatus("completed");
        List<Reservation> cancelled = reservationRepository.getStatus("cancelled");

        ReportStatus status = new ReportStatus(completed.size(), cancelled.size());
        return status;
    }

    public List<TopClients> getTopClient(){
        List<TopClients> newArray = new ArrayList<>();
        List<Object[]> result = reservationRepository.getTopClients();

        for(int i=0; i<result.size(); i++){
            int total = Integer.parseInt(result.get(i)[1].toString());
            Client client = (Client) result.get(i)[0];
            TopClients topClients = new TopClients(total, client);
            newArray.add(topClients);
        }
        return newArray;
    }
}
