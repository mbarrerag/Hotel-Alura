package org.example.logic.dao;

import org.example.logic.entitites.Huesped;
import org.example.logic.entitites.Reserve;
import org.example.logic.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class DaoReservation {

    private EntityManager em;
    public DaoReservation(EntityManager em){
        this.em=em;
    }
    public void save(Reserve reserve){
        this.em.persist(reserve);
    }

    public List<Reserve> getAllReservas() {
        List<Reserve> reservas = null;
        try {
            // Consulta JPA para seleccionar todas las reservas
            String jpql = "SELECT r FROM Reserve r";
            reservas = this.em.createQuery(jpql, Reserve.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservas;
    }

}
