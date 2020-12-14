package com.areteans.TicketBooking.controller;
import com.areteans.TicketBooking.models.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.areteans.TicketBooking.service.CommonService;
import com.areteans.TicketBooking.service.StationService;
import com.areteans.TicketBooking.service.TicketService;
import com.areteans.TicketBooking.service.TrainService;
import java.util.Map;
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "book")
public class TicketBookController {
    private final CommonService commonService;
    private final TicketService ticketService;
    private final TrainService trainService;
    private final StationService stationService;
    @CrossOrigin
    @PostMapping(path = "train", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> trainDetail(@RequestBody Map<String, Object> train) {
        return trainService.save(train); }
        @CrossOrigin
    @PostMapping(path = "ticket", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> ticketDetail(@RequestBody Map<String, Object> ticket) {
        return ticketService.saveT(ticket);}
        @CrossOrigin
        @PostMapping(path = "passenger", consumes = MediaType.APPLICATION_JSON_VALUE)
        public Map<String, Object> passengerDetail (@RequestBody Map < String, Object > passenger){
            return commonService.saveCom(passenger);}
            @CrossOrigin
        @PostMapping(path = "station", consumes = MediaType.APPLICATION_JSON_VALUE)
        public Map<String, Object> stationDetail (@RequestBody Map < String, Object > station){
            return stationService.save(station);}
            @CrossOrigin
    @PostMapping(path = "nestedticket", consumes = MediaType.APPLICATION_JSON_VALUE)
            public Ticket createBoardingPass(@RequestBody Ticket ticket) {
        return commonService.create(ticket);
    }
    @CrossOrigin
    @PostMapping(path = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> createPassenger(@RequestBody Map<String, Object> passengerJPA) {
        return commonService.createPassengerJPA(passengerJPA);
    }
}