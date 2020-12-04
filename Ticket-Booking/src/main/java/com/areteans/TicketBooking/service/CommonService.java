package com.areteans.TicketBooking.service;
import com.areteans.TicketBooking.enums.PassengerType;
import com.areteans.TicketBooking.models.Passenger;
import com.areteans.TicketBooking.models.PassengerJPA;
import com.areteans.TicketBooking.models.Ticket;
import com.areteans.TicketBooking.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;
@Service
@RequiredArgsConstructor
public class CommonService {
    private final ChildService childService;
    private final SeniorCitizenService seniorCitizenService;
    private final GeneralService generalService;
    private final PassengerRepository passengerRepository;
    private final JdbcTemplate jdbcTemplateForCreate;
    public Map<String, Object> save(Map<String, Object> Passenger) {
        switch (PassengerType.valueOf(String.valueOf(Passenger.get("PassengerType")))) {
            case CHILD:
                return childService.save(Passenger);
            case SENIOR_CITIZEN:
                return seniorCitizenService.save(Passenger);
            case GENERAL:
                return generalService.save(Passenger);
            default:
                return null;
        }
    }
    public Ticket create(Ticket ticket) {
        Map<String, Object> mapx = jdbcTemplateForCreate.queryForMap("insert into passenger(name,age,contact,address,idCard) values(?,?,?,?,?) RETURNING passengerid",
                ticket.getPassenger().getName(),
                ticket.getPassenger().getAge(),
                ticket.getPassenger().getContact(),
                ticket.getPassenger().getAddress(),
                ticket.getPassenger().getIdCard());
        jdbcTemplateForCreate.update("insert into ticket(ticketid,status,trainid,stationID_D,stationID_A,berthnumber,DepartureTime) values(?,?,?,?,?,?,?)",
                ticket.getTicketID(),
                ticket.getStatus(),
                ticket.getTrainID(),
                ticket.getStationID_D(),
                ticket.getSationID_A(),
                ticket.getBerthnumber(),
                ticket.getDepartureTime());
                mapx.get("passengerid");
        return ticket;
    }
    public Passenger create(Passenger passenger) {
        Map<String, Object> map = jdbcTemplateForCreate.queryForMap("insert into passenger(name,age,address,idCard,contact,PassengerType) values(?,?,?,?,?,?) RETURNING passengerid",
                passenger.getName(),
                passenger.getAge(),
                passenger.getAddress(),
                passenger.getIdCard(),
                passenger.getContact(),
                passenger.getPassengerType());
        return passenger;
    }
    @Transactional
    public Map<String, Object> createPassengerJPA(Map<String, Object> passengerJPA) {
        PassengerJPA passenger = new PassengerJPA(
                null,
                String.valueOf(passengerJPA.get("name")),
                (int) Long.parseLong(String.valueOf(passengerJPA.get("contact"))),
                String.valueOf(passengerJPA.get("address")),
                Integer.parseInt(String.valueOf(passengerJPA.get("age"))),
                Long.parseLong(String.valueOf(passengerJPA.get("idCard"))));
        PassengerJPA passenger1 = passengerRepository.save(passenger);
        passenger1.setAge(13);
        passengerRepository.save(passenger1);
        return new HashMap<>();
    }
}
