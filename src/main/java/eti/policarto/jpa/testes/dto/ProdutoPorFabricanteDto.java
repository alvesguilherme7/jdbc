package eti.policarto.jpa.testes.dto;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class ProdutoPorFabricanteDto {

    private final Long count;
    private final Long id;
    private final String descricao;
    private final String fabricante;

    public ProdutoPorFabricanteDto(Long count, Long id, String descricao, String fabricante) {
        this.count = count;
        this.id = id;
        this.descricao = descricao;
        this.fabricante = fabricante;
    }
}
