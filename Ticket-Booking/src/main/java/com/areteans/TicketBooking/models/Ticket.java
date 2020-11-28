package com.areteans.TicketBooking.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.sql.Time;
@Getter
@Setter
@AllArgsConstructor
public class Ticket {
    private long ticketID;
    private String status;
    private long trainID;
    private long stationID_D;
    private long sationID_A;
    private int berthnumber;
    Time DepartureTime;
    private Passenger passenger;
    public Ticket(Long ticketID, String status, Long trainID, Long stationID_D, Long stationID_A, Integer berthnumber, Time DepartureTime) {
        this.ticketID = ticketID;
        this.status = status;
        this.trainID = trainID;
        this.stationID_D = stationID_D;
        this.sationID_A = stationID_A;
        this.berthnumber = berthnumber;
        this.DepartureTime = DepartureTime;
    }
}
