package com.projeto.mamaecontente.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtesanatoDTO {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private int quantidade;
    private String urlImagem;
}
