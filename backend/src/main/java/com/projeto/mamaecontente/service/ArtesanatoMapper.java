package com.projeto.mamaecontente.service;

import com.projeto.mamaecontente.dto.ArtesanatoDTO;
import com.projeto.mamaecontente.model.Artesanato;
import org.springframework.stereotype.Component;

@Component
public class ArtesanatoMapper {

    public Artesanato toEntity(ArtesanatoDTO dto) {
        Artesanato entity = new Artesanato();
        entity.setId(dto.id());
        entity.setNome(dto.nome());
        entity.setDescricao(dto.descricao());
        entity.setPreco(dto.preco());
        entity.setQuantidade(dto.quantidade());
        entity.setUrlImagem(dto.urlImagem());
        return entity;
    }

    public ArtesanatoDTO toDTO(Artesanato entity) {
        return new ArtesanatoDTO(entity.getId(), entity.getNome(), entity.getDescricao(), entity.getPreco(),
                entity.getQuantidade(), entity.getUrlImagem());
    }
}
