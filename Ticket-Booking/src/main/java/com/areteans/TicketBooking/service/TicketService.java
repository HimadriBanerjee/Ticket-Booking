package com.areteans.TicketBooking.service;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.Map;
@Service
@RequiredArgsConstructor
public class TicketService {
    private final JdbcTemplate jdbcTemplateOfTicket;
    public Map<String, Object> saveT(Map<String, Object> ticket) {
        Map<String, Object> tiMap = jdbcTemplateOfTicket.queryForMap("insert into ticket(status,trainID,stationID_D,stationID_A,berthnumber) values(?,?,?,?,?) RETURNING ticketID",
             //   Integer.parseInt((String) ticket.get("ticketID")),
                ticket.get("status"),
                Long.parseLong((String) ticket.get("trainID")),
                Long.parseLong((String) ticket.get("stationID_D")),
                Long.parseLong((String) ticket.get("stationID_A")),
                Integer.parseInt((String) ticket.get("berthnumber")));
              //  Integer.parseInt((String) ticket.get("DepartureTime")));
                 ticket.put("ticketID" ,tiMap.get("ticketID"));
                  return ticket;
    }
}
