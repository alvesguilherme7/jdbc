package eti.policarto.jpa.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @ToString @EqualsAndHashCode
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    // mappedBy = evita que o relacionamento seja criado em duplicidade.
    // A relação aqui é necessária para que seja possível buscar os dados de produtos em um objeto de categoria
    @ManyToMany(mappedBy = "categoria")
    private List<Produto> produtos;

    public Categoria() {
    }

    public Categoria(String descricao) {
        this.descricao = descricao;
    }

}
