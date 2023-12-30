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

    public void update(Reserve reserva) {
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();
        try {
            // Obtenemos la reserva actual de la base de datos por su id
            Reserve reservaPersistente = em.find(Reserve.class, reserva.getId());

            // Actualizamos los campos de la reserva persistente con los de la nueva reserva
            reservaPersistente.setCheckIn(reserva.getCheckIn());
            reservaPersistente.setCheckOut(reserva.getCheckOut());
            reservaPersistente.setBookingValue(reserva.getBookingValue());
            reservaPersistente.setPaymentMethod(reserva.getPaymentMethod());

            // Confirmamos la transacción
            em.getTransaction().commit();
        } catch (Exception e) {
            // Manejo de excepciones
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void deleted(Long id) {
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();
        try {
            Reserve reserve = em.find(Reserve.class, id);

            if (reserve != null) {
                em.remove(reserve);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Reserve getById(Long id) {
        return em.find(Reserve.class, id);
    }


}
