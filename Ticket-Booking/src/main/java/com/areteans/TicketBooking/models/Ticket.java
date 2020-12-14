package com.areteans.TicketBooking.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.sql.Time;
@Getter
@Setter
@AllArgsConstructor
public class Ticket {
    private Long ticketID;
    private String status;
    private Long trainID;
    private Long stationID_D;
    private Long stationID_A;
    private Integer berthnumber;
   // Time DepartureTime;
    private Passenger passenger;
    public Ticket(Long ticketID, String status, Long trainID, Long stationID_D, Long stationID_A, Integer berthnumber) {
        this.ticketID = ticketID;
        this.status = status;
        this.trainID = trainID;
        this.stationID_D = stationID_D;
        this.stationID_A = stationID_A;
        this.berthnumber = berthnumber;
       // this.DepartureTime = DepartureTime;
    }
}
