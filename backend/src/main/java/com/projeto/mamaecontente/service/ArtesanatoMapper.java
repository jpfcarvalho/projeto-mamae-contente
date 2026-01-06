package com.projeto.mamaecontente.service;

import com.projeto.mamaecontente.dto.ArtesanatoDTO;
import com.projeto.mamaecontente.model.Artesanato;
import org.springframework.stereotype.Component;

@Component
public class ArtesanatoMapper {

    public Artesanato toEntity(ArtesanatoDTO dto) {
        Artesanato entity = new Artesanato();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setPreco(dto.getPreco());
        entity.setQuantidade(dto.getQuantidade());
        entity.setUrlImagem(dto.getUrlImagem());
        return entity;
    }

    public ArtesanatoDTO toDTO(Artesanato entity) {
        return new ArtesanatoDTO(entity.getId(), entity.getNome(), entity.getDescricao(), entity.getPreco(),
                entity.getQuantidade(), entity.getUrlImagem());
    }
}
