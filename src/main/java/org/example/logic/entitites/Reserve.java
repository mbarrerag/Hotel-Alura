package org.example.logic.entitites;
import  javax.persistence.*;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "reserve")
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Date checkIn;
    private Date checkOut;
    private Double bookingValue;
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "huesped_id")
    private Huesped huesped;

    public Long getId() {
        return Id;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public Double getBookingValue() {
        return bookingValue;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public Huesped getHuesped() {
        return huesped;
    }

}