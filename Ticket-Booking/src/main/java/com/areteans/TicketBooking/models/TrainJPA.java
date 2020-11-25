package com.areteans.TicketBooking.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
@Entity
@Table(name = "train")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrainJPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainID;
    private String trainName;
}
