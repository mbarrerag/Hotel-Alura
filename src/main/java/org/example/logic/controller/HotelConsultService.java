package org.example.logic.controller;

import org.example.logic.dao.DaoHuesped;
import org.example.logic.entitites.Huesped;
import org.example.logic.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class HotelConsultService {


    public HotelConsultService() {
    }

    public void consultGuest(){

        EntityManager em = JPAUtils.getEntityManager();
        DaoHuesped daoHuesped = new DaoHuesped(em);
        List<Huesped> huespedList = daoHuesped.consultHuesped();
        huespedList.forEach(huesped -> System.out.println(huesped.getName()));


    }

}
