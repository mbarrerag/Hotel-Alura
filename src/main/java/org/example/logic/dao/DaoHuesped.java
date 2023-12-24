package org.example.logic.dao;

import org.example.logic.entitites.Reserve;

import javax.persistence.EntityManager;

public class DaoHuesped {

    private EntityManager em;
    public DaoHuesped(EntityManager em){
        this.em=em;
    }
    public void save(Reserve reserve){
        this.em.persist(reserve);
    }

}