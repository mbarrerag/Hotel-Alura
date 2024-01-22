package org.example.logic.entitites;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The Reserve class represents a reservation entity in the hotel management system.
 */
@Entity
@Table(name = "reserve")
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Date checkIn;
    private Date checkOut;
    private BigDecimal bookingValue;
    private String paymentMethod;
    private int reservationNumber;

    @ManyToOne
    @JoinColumn(name = "huesped_id")
    private Huesped huesped;

    /**
     * Gets the id of the Reserve entity.
     *
     * @return The id of the Reserve entity.
     */
    public Long getId() {
        return Id;
    }

    /**
     * Sets the id of the Reserve entity.
     *
     * @param id The id to set for the Reserve entity.
     */
    public void setId(Long id) {
        Id = id;
    }

    /**
     * Gets the check-in date of the reservation.
     *
     * @return The check-in date of the reservation.
     */
    public Date getCheckIn() {
        return checkIn;
    }

    /**
     * Sets the check-in date of the reservation.
     *
     * @param checkIn The check-in date to set for the reservation.
     */
    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    /**
     * Gets the check-out date of the reservation.
     *
     * @return The check-out date of the reservation.
     */
    public Date getCheckOut() {
        return checkOut;
    }

    /**
     * Sets the check-out date of the reservation.
     *
     * @param checkOut The check-out date to set for the reservation.
     */
    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    /**
     * Gets the booking value of the reservation.
     *
     * @return The booking value of the reservation.
     */
    public BigDecimal getBookingValue() {
        return bookingValue;
    }

    /**
     * Sets the booking value of the reservation.
     *
     * @param bookingValue The booking value to set for the reservation.
     */
    public void setBookingValue(BigDecimal bookingValue) {
        this.bookingValue = bookingValue;
    }

    /**
     * Gets the payment method used for the reservation.
     *
     * @return The payment method used for the reservation.
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the payment method used for the reservation.
     *
     * @param paymentMethod The payment method to set for the reservation.
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Gets the guest associated with the reservation.
     *
     * @return The guest associated with the reservation.
     */
    public Huesped getHuesped() {
        return huesped;
    }

    /**
     * Sets the guest associated with the reservation.
     *
     * @param huesped The guest to set for the reservation.
     */
    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    /**
     * Gets the reservation number.
     *
     * @return The reservation number.
     */
    public int getReservationNumber() {
        return reservationNumber;
    }

    /**
     * Sets the reservation number.
     *
     * @param reservationNumber The reservation number to set.
     */
    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }
}
