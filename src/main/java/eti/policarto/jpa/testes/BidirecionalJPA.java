package eti.policarto.jpa.testes;

import eti.policarto.jpa.model.Categoria;
import eti.policarto.jpa.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class BidirecionalJPA {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("loja");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Produto produto = entityManager.find(Produto.class, 1L);
        List<Categoria> categorias = produto.getCategoria();
        for (Categoria categoria : categorias) {
            System.out.printf("Categoria: %s%n\tProdutos:%n", categoria.getDescricao());
            categoria.getProdutos().forEach(System.out::println);
        }

        entityManager.close();
    }
}
