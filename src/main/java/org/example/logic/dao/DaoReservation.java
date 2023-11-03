package org.example.logic.dao;

import org.example.logic.entitites.Huesped;
import org.example.logic.entitites.Reserve;

import javax.persistence.EntityManager;

public class DaoReservation {

    private EntityManager em;
    public void ReserveDao(EntityManager em){
        this.em=em;
    }
    public void save(Reserve reserva){
        this.em.persist(reserva);
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        DaoReservation edao = new DaoReservation();
        Huesped huesped = new Huesped();

    }

}
