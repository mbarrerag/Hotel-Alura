package org.example.logic.dao;

import org.example.logic.entitites.Huesped;
import org.example.logic.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * The DaoHuesped class provides data access methods for managing Huesped entities in the database
 * using Hibernate and JPA.
 */
public class DaoHuesped {

    private EntityManager em;

    /**
     * Constructor to initialize the DaoHuesped with an EntityManager.
     *
     * @param em The EntityManager instance.
     */
    public DaoHuesped(EntityManager em) {
        this.em = em;
    }

    /**
     * Saves a Huesped entity to the database.
     *
     * @param huesped The Huesped entity to be saved.
     */
    public void save(Huesped huesped) {
        this.em.persist(huesped);
    }

    /**
     * Retrieves a list of all Huesped entities from the database.
     *
     * @return List of Huesped entities.
     */
    public List<Huesped> consultHuesped() {
        String jpql = "SELECT p FROM Huesped p";
        return em.createQuery(jpql, Huesped.class).getResultList();
    }

    /**
     * Retrieves a list of all Huesped entities with their associated reserves from the database.
     *
     * @return List of Huesped entities with eagerly fetched reserves.
     */
    public List<Huesped> getAllHuespedes() {
        EntityManager em = JPAUtils.getEntityManager();
        List<Huesped> huespedes = null;
        try {
            String jpql = "SELECT h FROM Huesped h LEFT JOIN FETCH h.reserves";
            huespedes = em.createQuery(jpql, Huesped.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return huespedes;
    }

    /**
     * Updates a Huesped entity in the database.
     *
     * @param huesped The updated Huesped entity.
     */
    public void update(Huesped huesped) {
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();
        try {
            // Obtain the persistent Huesped entity from the database by its id
            Huesped huespedPersistence = em.find(Huesped.class, huesped.getId());

            // Update the fields of the persistent Huesped entity with those of the new Huesped
            huespedPersistence.setName(huesped.getName());
            huespedPersistence.setSurename(huesped.getSurename());
            huespedPersistence.setBirthdate(huesped.getBirthdate());
            huespedPersistence.setCellphone(huesped.getCellphone());

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
     * Retrieves a Huesped entity by its id from the database.
     *
     * @param id The id of the Huesped entity to retrieve.
     * @return The Huesped entity.
     */
    public Huesped getById(Long id) {
        return em.find(Huesped.class, id);
    }

    /**
     * Deletes a Huesped entity from the database by its id.
     *
     * @param id The id of the Huesped entity to delete.
     */
    public void deleted(Long id) {
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();
        try {
            Huesped huesped = em.find(Huesped.class, id);

            if (huesped != null) {
                em.remove(huesped);
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
     * Retrieves a Huesped entity by its cellphone number from the database.
     *
     * @param cellphone The cellphone number of the Huesped entity to retrieve.
     * @return The Huesped entity.
     */
    public Huesped getByCellphone(String cellphone) {
        EntityManager em = JPAUtils.getEntityManager();
        Huesped huesped = null;
        try {
            String jpql = "SELECT h FROM Huesped h WHERE h.cellphone = :cellphone";
            huesped = em.createQuery(jpql, Huesped.class).setParameter("cellphone", cellphone).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return huesped;
    }
}
