package com.areteans.TicketBooking.service;
import lombok.RequiredArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.Map;
@Service
@RequiredArgsConstructor
public class TicketDetailsService {
    private final JdbcTemplate jdbctemplateTrainDet;
    public Map<String, Object> TicketAttributes(Integer ticketID) {
        return jdbctemplateTrainDet.queryForMap("select * from ticket where ticketID=?", ticketID);
    }
}