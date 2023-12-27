package org.example.logic.dao;

import org.example.logic.entitites.Huesped;

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

}