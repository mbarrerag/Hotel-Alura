package org.example.logic.dao;

import org.example.logic.entitites.Huesped;
import org.example.logic.entitites.Reserve;
import org.example.logic.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.util.List;


public class DaoHuesped {

    private EntityManager em;
    public DaoHuesped(EntityManager em){
        this.em=em;
    }
    public void save(Huesped reserve){
        this.em.persist(reserve);
    }

    public List<Huesped> consultHuesped(){
        String jpql = "SELECT p FROM Huesped p";
        return em.createQuery(jpql, Huesped.class).getResultList();
    }

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
        System.out.println(huespedes);
        return huespedes;
    }


    public void update(Huesped huesped) {
        EntityManager em = JPAUtils.getEntityManager();
        em.getTransaction().begin();
        try {
            // Obtenemos la reserva actual de la base de datos por su id
            Huesped huespedPersistance = em.find(Huesped.class, huesped.getId());

            // Actualizamos los campos de la reserva persistente con los de la nueva reserva
            huespedPersistance.setName(huesped.getName());
            huespedPersistance.setSurename(huesped.getSurename());
            huespedPersistance.setBirthdate(huesped.getBirthdate());
            huespedPersistance.setCellphone(huesped.getCellphone());

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
    public Huesped getById(Long id) {
        return em.find(Huesped.class, id);
    }


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