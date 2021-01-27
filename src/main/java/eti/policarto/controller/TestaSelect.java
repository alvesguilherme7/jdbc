package eti.policarto.controller;

import eti.policarto.dao.ProdutoDAO;

public class TestaSelect {

    public static void main( String[] args ) throws Exception {

        new ProdutoDAO()
                .findAll()
                .forEach(System.out::println);

    }
}
