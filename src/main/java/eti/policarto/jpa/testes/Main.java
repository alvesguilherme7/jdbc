package eti.policarto.jpa.testes;

import eti.policarto.jpa.model.Categoria;
import eti.policarto.jpa.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        Categoria categoria = new Categoria("Ehverdade");

        Produto bolaFutebol = new Produto();
        bolaFutebol.setNome("Bola de Futebol");
        bolaFutebol.setDescricao("Bola Adidas Official UEFA Champions League");


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("loja");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(bolaFutebol);
        entityManager.getTransaction().commit();
    }
}
