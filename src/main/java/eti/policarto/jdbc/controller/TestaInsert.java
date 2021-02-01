package eti.policarto.jdbc.controller;

import eti.policarto.jdbc.dao.ProdutoDAO;
import eti.policarto.jdbc.model.Produto;

public class TestaInsert {

    public static void main( String[] args ) throws Exception {

        Produto produto = new Produto("Smartphone H1", "Television Smartphone H1",1L);
        new ProdutoDAO().save(produto);

        Produto produto2 = new Produto("Fogão Elétrico", "Brastemp Fogão Elétrico",2L);
        new ProdutoDAO().save(produto2);

        Produto produto3 = new Produto("Bicicleta", "Bicicleta Shimano",3L);
        new ProdutoDAO().save(produto3);

    }
}
