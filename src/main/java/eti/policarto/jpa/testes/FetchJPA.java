package eti.policarto.jpa.testes;

import eti.policarto.jpa.dao.ProdutoDAO;
import eti.policarto.jpa.model.Produto;

public class FetchJPA {
    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();

        for (Produto produto : produtoDAO.findAllWithCategoria()) {
            System.out.println(produto.getNome());
            produto.getCategoria().forEach(System.out::println);
        }

    }
}
