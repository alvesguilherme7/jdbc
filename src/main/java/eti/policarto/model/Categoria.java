package eti.policarto.model;

import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter @Setter @ToString @EqualsAndHashCode
public class Categoria {

    private Long id;
    private String descricao;

    public Categoria(String descricao) {
        this.descricao = descricao;
    }

    public Categoria(ResultSet rsCategorias) throws SQLException {
        this.id = rsCategorias.getLong("ID");
        this.descricao = rsCategorias.getString("DESCRICAO");
    }

    public boolean compareToId(Long id){
        return id.equals(this.getId());
    }
}
