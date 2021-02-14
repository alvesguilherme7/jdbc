package eti.policarto.jpa.commons;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerFactory {

    private static javax.persistence.EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    static {
        EntityManagerFactory.entityManagerFactory = Persistence.createEntityManagerFactory("loja");
        EntityManagerFactory.entityManager = entityManagerFactory.createEntityManager();
    }

    public static EntityManager getEntityManager(){
        return EntityManagerFactory.entityManager;
    }

}
