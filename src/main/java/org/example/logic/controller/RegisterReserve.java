package org.example.logic.controller;

import org.example.logic.dao.DaoReservation;
import org.example.logic.entitites.Reserve;
import org.example.logic.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The RegisterReserve class provides a method to register a new reservation by creating a Reserve entity
 * and saving it to the database using Hibernate and JPA.
 */
public class RegisterReserve {

        /**
         * Constructor to create and register a new reservation in the database.
         *
         * @param dateCheckIn    The check-in date of the reservation.
         * @param dateCheckOut   The check-out date of the reservation.
         * @param paymentMethod  The payment method used for the reservation.
         * @param bookingValue   The booking value or cost of the reservation.
         */
        public RegisterReserve(Date dateCheckIn, Date dateCheckOut, String paymentMethod, BigDecimal bookingValue) {
                // Create a new Reserve entity with the provided information
                Reserve reserve = new Reserve();
                reserve.setCheckIn(dateCheckIn);
                reserve.setCheckOut(dateCheckOut);
                reserve.setPaymentMethod(paymentMethod);
                reserve.setBookingValue(bookingValue);

                // Get the EntityManager and DAO for Reserve
                EntityManager em = JPAUtils.getEntityManager();
                DaoReservation daoReservation = new DaoReservation(em);

                try {
                        // Begin a transaction, save the Reserve entity, commit the transaction, and close the EntityManager
                        em.getTransaction().begin();
                        daoReservation.save(reserve);
                        em.getTransaction().commit();
                } finally {
                        em.close();
                }
        }
}
