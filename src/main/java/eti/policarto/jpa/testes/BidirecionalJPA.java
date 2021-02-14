package eti.policarto.jpa.testes;

import eti.policarto.jpa.dao.ProdutoDAO;
import eti.policarto.jpa.model.Categoria;
import eti.policarto.jpa.model.Produto;

import java.util.List;

public class BidirecionalJPA {
    public static void main(String[] args) {
        Produto produto = new ProdutoDAO().findById(1L);
        List<Categoria> categorias = produto.getCategoria();
        for (Categoria categoria : categorias) {
            System.out.printf("Categoria: %s%n\tProdutos:%n", categoria.getDescricao());
            categoria.getProdutos().forEach(System.out::println);
        }
    }
}
