package org.example.logic.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtils {
    private static EntityManagerFactory Factory = Persistence.createEntityManagerFactory("hotel");
        public static EntityManager getEntityManager(){
            return Factory.createEntityManager();
        }
}
