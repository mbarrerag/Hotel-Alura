package org.example.logic.controller;

import org.example.logic.dao.DaoReservation;
import org.example.logic.entitites.Huesped;
import org.example.logic.entitites.Reserve;
import org.example.logic.utils.JPAUtils;

import javax.persistence.EntityManager;

public class RegisteReserve {

    public static void main(String[] args) {
        EntityManager em = JPAUtils.getEntityManager();
        DaoReservation daoReservation = new DaoReservation(em);

        em.getTransaction().begin();

        Huesped huesped = new Huesped();
        huesped.setCellphone("123456789");
        huesped.setBirthdate(null);
        huesped.setName("Juan");
        huesped.setSurename("Perez");

        // Persist the Huesped instance first
        em.persist(huesped);

        Reserve reserve = new Reserve();
        reserve.setPaymentMethod("Efectivo");
        reserve.setBookingValue(null);
        reserve.setCheckOut(null);
        reserve.setCheckIn(null);

        // Set the previously persisted Huesped instance
        reserve.setHuesped(huesped);

        // Now persist the Reserve instance
        daoReservation.save(reserve);

        em.getTransaction().commit();
        em.close();
    }

}
