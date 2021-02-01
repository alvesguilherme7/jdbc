package eti.policarto.jpa.testes;

import eti.policarto.jpa.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JPQL {
    public static void main(String[] args) {

        String jpql = " select pro from Produto pro where pro.fabricante.nome like 'Adidas' ";

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("loja");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Produto> produtos = entityManager.createQuery(jpql).getResultList();
        produtos.forEach(System.out::println);

        entityManager.close();

    }
}
