package org.example.logic.controller;

import org.example.logic.dao.DaoHuesped;
import org.example.logic.utils.JPAUtils;
import org.example.logic.entitites.Huesped;

import javax.persistence.EntityManager;
import java.util.Date;

/**
 * The RegisterGuest class provides a method to register a new guest by creating a Huesped entity
 * and saving it to the database using Hibernate and JPA.
 */
public class RegisterGuest {

    /**
     * Constructor to create and register a new guest in the database.
     *
     * @param name        The name of the guest.
     * @param surname     The surname of the guest.
     * @param birthDay    The birthdate of the guest.
     * @param nationality The nationality of the guest.
     * @param cellphone   The cellphone number of the guest.
     */
    public RegisterGuest(String name, String surname, Date birthDay, String nationality, String cellphone) {
        // Create a new Huesped entity with the provided information
        Huesped huesped = new Huesped();
        huesped.setName(name);
        huesped.setSurename(surname);
        huesped.setBirthdate(birthDay);
        huesped.setNationality(nationality);
        huesped.setCellphone(cellphone);

        // Get the EntityManager and DAO for Huesped
        EntityManager em = JPAUtils.getEntityManager();
        DaoHuesped daoHuesped = new DaoHuesped(em);

        try {
            // Begin a transaction, save the Huesped entity, commit the transaction, and close the EntityManager
            em.getTransaction().begin();
            daoHuesped.save(huesped);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
