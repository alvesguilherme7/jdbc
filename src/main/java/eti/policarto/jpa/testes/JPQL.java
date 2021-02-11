package eti.policarto.jpa.testes;

import eti.policarto.jpa.model.Fabricante;
import eti.policarto.jpa.model.Produto;

import javax.persistence.*;
import java.util.List;

public class JPQL {
    public static void main(String[] args) {

        String jpql = " select pro from Produto pro where pro.fabricante.nome like 'Adidas' order by classificacao ";
        // ou
        String jpqlOO = " select pro from Produto pro where pro.fabricante = :pFabricante order by classificacao ";

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("loja");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Fabricante fabricante = new Fabricante("Adidas");
        // "simular" o estado JPA Trasient -> Managed
        fabricante.setId(1L);

        // jpql simples
        createTitle("jpql simples");
        TypedQuery<Produto> query = entityManager.createQuery(jpqlOO, Produto.class);
        query.setParameter("pFabricante", fabricante);
        List<Produto> produtos = query.getResultList();
        produtos.forEach(System.out::println);

        // jpql com join
        createTitle("jpql com join");
        jpql = " select pro from Produto pro join pro.categoria cat on cat.descricao like '%esportes%' ";
        query = entityManager.createQuery(jpql, Produto.class);
        produtos = query.getResultList();
        produtos.forEach(System.out::println);


        entityManager.close();

    }

    private static void createTitle(String m) {
        System.out.printf("%n************** %s **************%n", m);
    }
}
