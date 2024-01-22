package org.example.logic.dao;

import org.example.logic.entitites.Reserve;
import org.example.logic.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * The DaoReservation class provides data access methods for managing Reserve entities in the database
 * using Hibernate and JPA.
 */
public class DaoReservation {

    private EntityManager em;

    /**
     * Constructor to initialize the DaoReservation with an EntityManager.
     *
     * @param em The EntityManager instance.
     */
    public DaoReservation(EntityManager em) {
        this.em = em;
    }

    /**
     * Saves a Reserve entity to the database.
     *
     * @param reserve The Reserve entity to be saved.
     */
    public void save(Reserve reserve) {
        this.em.persist(reserve);
    }

    /**
     * Retrieves a list of all Reserve entities from the database.
     *
     * @return List of Reserve entities.
     */
    public List<Reserve> getAllReservas() {
        List<Reserve> reservas = null;
        try {
            // JPA query to select all reserves
            String jpql = "SELECT r FROM Reserve r";
            reservas = this.em.createQuery(jpql, Reserve.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reservas;
    }

    /**
     * Updates a Reserve entity in the database.
     *
     * @param reserva The updated Reserve entity.
     */
    public void update(Reserve reserva) {
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();
        try {
            // Obtain the persistent Reserve entity from the database by its id
            Reserve reservaPersistente = em.find(Reserve.class, reserva.getId());

            // Update the fields of the persistent Reserve entity with those of the new Reserve
            reservaPersistente.setCheckIn(reserva.getCheckIn());
            reservaPersistente.setCheckOut(reserva.getCheckOut());
            reservaPersistente.setBookingValue(reserva.getBookingValue());
            reservaPersistente.setPaymentMethod(reserva.getPaymentMethod());

            // Commit the transaction
            em.getTransaction().commit();
        } catch (Exception e) {
            // Exception handling
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    /**
     * Deletes a Reserve entity from the database by its id.
     *
     * @param id The id of the Reserve entity to delete.
     */
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

    /**
     * Retrieves a Reserve entity by its id from the database.
     *
     * @param id The id of the Reserve entity to retrieve.
     * @return The Reserve entity.
     */
    public Reserve getById(Long id) {
        return em.find(Reserve.class, id);
    }

    /**
     * Deletes a Reserve entity from the database by its id.
     * Note: This method duplicates functionality with the 'deleted' method and may be unnecessary.
     *
     * @param id The id of the Reserve entity to delete.
     */
    public void eliminar(Long id) {
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
}
