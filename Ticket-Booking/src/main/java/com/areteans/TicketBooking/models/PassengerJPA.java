package com.areteans.TicketBooking.models;
import com.areteans.TicketBooking.enums.PassengerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "passenger")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PassengerJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passengerid;
    private String name;
    private int age;
    private String address;
    private long idCard;
    private long contact;

    //public PassengerJPA(Long passengerid,String name, int contact, String address, int age, long idCard) {
   // }
}
