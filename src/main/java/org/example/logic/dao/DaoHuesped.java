package org.example.logic.dao;

import org.example.logic.entitites.Huesped;
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

}