package com.areteans.TicketBooking.models;
import com.areteans.TicketBooking.enums.PassengerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class Passenger {
    private String name;
    private  int age;
    private String address;
    private long idCard;
    private long contact;
    private PassengerType PassengerType;
    public Passenger(String name,Integer age,String address,Long contact,Long idCard){
        this.name=name;
        this.age=age;
        this.address=address;
        this.contact=contact;
        this.idCard = idCard;
    }
   /* public String getAddress(){return  address;}
    public void setAddress(String address){this.address=address;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public int getIdCard(){return  idCard;}
    public void setIdCard(int idCard){this.idCard=idCard;}
    public long getContact(){return  contact;}
    public void setContact(long contact){this.contact=contact;}
    public int getAge(){return  age;}
    public void setAge(int age){this.age=age;}
    public abstract PassengerType getPassengerType();*/
}
