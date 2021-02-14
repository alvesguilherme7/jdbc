package eti.policarto.jpa.testes;

import eti.policarto.jpa.testes.dto.ProdutoPorFabricanteDto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class FuncoesSQlJPA {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("loja");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        String jpql = " select new eti.policarto.jpa.testes.dto.ProdutoPorFabricanteDto(count(1), p.id, p.descricao, p.fabricante.nome) from Produto p group by p.fabricante.nome ";

        entityManager.getTransaction().begin();

        TypedQuery<ProdutoPorFabricanteDto> query = entityManager.createQuery(jpql, ProdutoPorFabricanteDto.class);
        query.getResultList().forEach(System.out::println);

        entityManager.getTransaction().commit();
    }
}
