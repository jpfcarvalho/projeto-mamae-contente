package com.projeto.mamaecontente.dto;

import java.math.BigDecimal;

public record ArtesanatoDTO (Long id, String nome, String descricao,
                             BigDecimal preco, int quantidade, String urlImagem){ }
