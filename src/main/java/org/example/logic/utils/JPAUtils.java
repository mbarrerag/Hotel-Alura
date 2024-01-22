package org.example.logic.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * The JPAUtils class provides utility methods for managing JPA entities and EntityManager instances.
 */
public class JPAUtils {

    private static EntityManagerFactory Factory = Persistence.createEntityManagerFactory("alura-hotel");

    /**
     * Gets an EntityManager instance from the configured EntityManagerFactory.
     *
     * @return The EntityManager instance.
     */
    public static EntityManager getEntityManager() {
        return Factory.createEntityManager();
    }
}
