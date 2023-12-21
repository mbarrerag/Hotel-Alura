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

    public void setId(Long id) {
        Id = id;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Double getBookingValue() {
        return bookingValue;
    }

    public void setBookingValue(Double bookingValue) {
        this.bookingValue = bookingValue;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }
/*aas*/
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }
}