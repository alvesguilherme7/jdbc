package eti.policarto.controller;

import eti.policarto.dao.CategoriaDAO;
import eti.policarto.dao.ProdutoDAO;
import eti.policarto.model.Categoria;
import eti.policarto.model.Produto;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestaSelect {

    public static void main( String[] args ) throws Exception {

        List<Produto> produtos = new ProdutoDAO().findAll();

        List<Categoria> categorias = new CategoriaDAO().findAll();

        produtos
            .stream()
            .collect(Collectors.groupingBy(Produto::getCategoriaId))
            .forEach((catId, prodsPorCat) -> {
                categorias
                        .stream()
                        .filter(mesmaCategoria(catId))
                        .findFirst()
                        .ifPresent(c -> print(c, produtos));
            });


    }

    private static Predicate<Categoria> mesmaCategoria(Long catId) {
        return it -> it.compareToId(catId);
    }

    private static void print(Categoria categoria, List<Produto> produtos) {
        System.out.printf("Categoria %s:%n\t", categoria.getDescricao());
        produtos.stream().filter(produto -> produto.getCategoriaId().equals(categoria.getId())).forEach(System.out::println);
    }

}
