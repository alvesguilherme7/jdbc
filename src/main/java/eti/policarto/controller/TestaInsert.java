package eti.policarto.controller;

import eti.policarto.dao.ProdutoDAO;
import eti.policarto.model.Produto;

public class TestaInsert {

    public static void main( String[] args ) throws Exception {

        final Produto produto = new Produto("Smartphone H1", "Television Smartphone H1");
        new ProdutoDAO().save(produto);

    }
}
