package eti.policarto.jpa.testes;

import eti.policarto.jpa.commons.Classificacao;
import eti.policarto.jpa.model.Categoria;
import eti.policarto.jpa.model.Fabricante;
import eti.policarto.jpa.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class RelacionamentosJPA {
    public static void main(String[] args) {

        List<Categoria> categorias = new ArrayList<>();
        categorias.add(new Categoria("Futebol"));
        categorias.add(new Categoria("Esportes"));
        categorias.add(new Categoria("Popular"));

        Fabricante fabricante = new Fabricante("Adidas");

        Produto bolaFutebol = new Produto();
        bolaFutebol.setNome("Bola de Futebol");
        bolaFutebol.setDescricao("Bola Adidas Official UEFA Champions League");
        bolaFutebol.setClassificacao(Classificacao.BOM);
        bolaFutebol.setCategoria(categorias);
        bolaFutebol.setFabricante(fabricante);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("loja");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        categorias.forEach(entityManager::persist);
        entityManager.persist(fabricante);
        entityManager.persist(bolaFutebol);

        entityManager.getTransaction().commit();

        entityManagerFactory.close();


    }
}
