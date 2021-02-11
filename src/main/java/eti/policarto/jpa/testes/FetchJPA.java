package eti.policarto.jpa.testes;

import eti.policarto.jpa.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class FetchJPA {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("loja");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // fetch força o carregamento da ligação toMany
        String jpql = " select p from Produto p left join fetch p.categoria ";
        TypedQuery<Produto> query = entityManager.createQuery(jpql, Produto.class);
        for (Produto produto : query.getResultList()) {
            System.out.println(produto.getNome());
            produto.getCategoria().forEach(System.out::println);
        }

        entityManager.close();
    }
}
