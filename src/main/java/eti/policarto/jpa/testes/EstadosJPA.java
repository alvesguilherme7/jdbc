package eti.policarto.jpa.testes;

import eti.policarto.jpa.model.Categoria;
import eti.policarto.jpa.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EstadosJPA {
    public static void main(String[] args) {

        // Estado JPA = Trasient
        Categoria categoriaEsportes = new Categoria("Esportes");
        Produto bolaFutebol = new Produto("Bola de Futebol", "Bola Adidas Official UEFA Champions League");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("loja");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        // Estado JPA = Trasient -> Managed
        entityManager.persist(categoriaEsportes);
        entityManager.persist(bolaFutebol);

        entityManager.getTransaction().commit();

        entityManagerFactory.close();

        // Estato JPA = Trasient -> Managed -> Detached
        bolaFutebol.setNome("Bola de Futebol Adidas");

        entityManagerFactory = Persistence.createEntityManagerFactory("loja");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        // Estato JPA = Trasient -> Managed -> Detached -> Managed -> Removed
        entityManager.remove( entityManager.merge(bolaFutebol) );

        entityManager.getTransaction().commit();

        entityManagerFactory.close();


    }
}
