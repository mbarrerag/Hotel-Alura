package org.example.logic.dao;

import org.example.logic.entitites.Huesped;

import javax.persistence.EntityManager;

public class DaoHuesped {

    private EntityManager em;
    public DaoHuesped(EntityManager em){
        this.em=em;
    }
    public void save(Huesped reserve){
        this.em.persist(reserve);
    }

}