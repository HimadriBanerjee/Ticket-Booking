package com.areteans.TicketBooking.controller;
import com.areteans.TicketBooking.service.TicketDetailsService;
import com.areteans.TicketBooking.service.TrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "enquire")
public class TicketDetailsController {
    private final TicketDetailsService ticketDetailsService;
    private final TrainService trainService;
    @CrossOrigin
    @GetMapping(path = "ticket")
    public Map<String, Object> GetTicketAttributes(@RequestParam(value = "ticketID")Integer ticketID){
        return this.ticketDetailsService.TicketAttributes(ticketID);
    }
}