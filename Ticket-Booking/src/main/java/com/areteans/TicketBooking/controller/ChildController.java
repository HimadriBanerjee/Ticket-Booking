package com.areteans.TicketBooking.controller;
import org.springframework.web.bind.annotation.*;
import com.areteans.TicketBooking.service.ChildService;
import org.springframework.http.MediaType;
import lombok.RequiredArgsConstructor;
import java.util.Map;
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "child")
public class ChildController {
    private final ChildService childService;
    @PostMapping(path = "create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> saveChild(@RequestBody Map<String, Object> Child){ return childService.saveC(Child);}
    @PutMapping(path="update",consumes=MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> updateChild(@RequestBody Map<String,Object>Child){return childService.saveC(Child);}
}

