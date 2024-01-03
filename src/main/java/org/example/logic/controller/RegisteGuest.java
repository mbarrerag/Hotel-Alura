package org.example.logic.controller;
import org.example.logic.dao.DaoHuesped;
import org.example.logic.utils.JPAUtils;
import javax.persistence.EntityManager;
import org.example.logic.entitites.Huesped;
import org.example.logic.entitites.Reserve;

import org.example.views.ReservationsView;
import org.example.logic.dao.DaoReservation;
import org.example.logic.entitites.Huesped;
import org.example.logic.entitites.Reserve;
import org.example.logic.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Date;

public class RegisteGuest {


    public RegisteGuest(String name, String surname, Date birthDay, String nationality, String cellphone) {

        Huesped huesped = new Huesped();
        huesped.setName(name);
        huesped.setSurename(surname);
        huesped.setBirthdate(birthDay);
        huesped.setNationality(nationality);
        huesped.setCellphone(cellphone);



        EntityManager em = JPAUtils.getEntityManager();
        DaoHuesped daoHuesped = new DaoHuesped(em);
        em.getTransaction().begin();
        daoHuesped.save(huesped);
        em.getTransaction().commit();
        em.close();

    }
}
