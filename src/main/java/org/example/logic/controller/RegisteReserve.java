
package org.example.logic.controller;
import org.example.views.ReservationsView;
import org.example.logic.dao.DaoReservation;
import org.example.logic.entitites.Huesped;
import org.example.logic.entitites.Reserve;
import org.example.logic.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Date;

public class RegisteReserve {


        public RegisteReserve(Date dateCheckIn, Date dateCheckOut, String paymentMethod, BigDecimal bookingValue) {

                Reserve reserve = new Reserve();
                reserve.setCheckIn(dateCheckIn);
                reserve.setCheckOut(dateCheckOut);
                reserve.setPaymentMethod(paymentMethod);
                reserve.setBookingValue(bookingValue);


        EntityManager em = JPAUtils.getEntityManager();
        DaoReservation daoReservation = new DaoReservation(em);

        em.getTransaction().begin();
        daoReservation.save(reserve);

        em.getTransaction().commit();
        em.close();
        }



    }

