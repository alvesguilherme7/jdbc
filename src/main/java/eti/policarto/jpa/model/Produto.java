package eti.policarto.jpa.model;

import eti.policarto.jpa.commons.Classificacao;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @ToString(exclude = "categoria") @EqualsAndHashCode
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    @OneToOne @JoinColumn( unique = false)
    private Fabricante fabricante;

    @Enumerated(EnumType.STRING)
    private Classificacao classificacao;

    // por padrão, relacionamentos toMany carregam os dados de maneira (LAZY)
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private List<Categoria> categoria;

    public Produto() {
    }

    public Produto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
}
