package com.areteans.TicketBooking.service;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.Map;
@Service
@RequiredArgsConstructor
public class SeniorCitizenService {
    private final JdbcTemplate jdbcTemplate;
    public Map<String, Object> save(Map<String, Object> passenger) {
        Map<String, Object> scMap = jdbcTemplate.queryForMap("insert into passenger(idCard,name,age,address,contact,PassengerType) values(?,?,?,?,?,?) RETURNING passengerid",
                Long.parseLong((String) passenger.get("idCard")),
                passenger.get("name"),
                Integer.parseInt((String) passenger.get("age")),
                passenger.get("address"),
                Long.parseLong((String) passenger.get("contact")),
        passenger.get("PassengerType"));
        passenger.put("passengerid", scMap.get("passengerid"));
        return passenger;
    }
}