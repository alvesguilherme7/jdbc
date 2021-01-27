package eti.policarto.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter @Setter @ToString @EqualsAndHashCode
public class Produto {

    private Long id;
    private String nome;
    private String descricao;
    private Long categoriaId;

    public Produto(String nome, String descricao, Long categoriaId) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoriaId = categoriaId;
    }

    public Produto(ResultSet rsProdutos) throws SQLException {
        this.id = rsProdutos.getLong("ID");
        this.nome = rsProdutos.getString("NOME");
        this.descricao = rsProdutos.getString("DESCRICAO");
        this.categoriaId = rsProdutos.getLong("CATEGORIA_ID");
    }
}
