package com.projeto.mamaecontente.service;

import com.projeto.mamaecontente.dto.ArtesanatoDTO;
import com.projeto.mamaecontente.model.Artesanato;
import com.projeto.mamaecontente.repository.ArtesanatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ArtesanatoService {

    private ArtesanatoRepository artesanatoRepository;

    private ArtesanatoMapper artesanatoMapper;

    public List<ArtesanatoDTO> findAll() {
        return artesanatoRepository.findAll()
                .stream()
                .map(artesanatoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ArtesanatoDTO findById(Long id) {
        return artesanatoRepository.findById(id)
                .map(artesanatoMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Artesanato não encontrado"));
    }

    public ArtesanatoDTO save(ArtesanatoDTO artesanatoDTO) {
        Artesanato artesanato = artesanatoMapper.toEntity(artesanatoDTO);
        Artesanato savedArtesanato = artesanatoRepository.save(artesanato);
        return artesanatoMapper.toDTO(savedArtesanato);
    }

    public ArtesanatoDTO update(Long id, ArtesanatoDTO artesanatoDTO) {
        return artesanatoRepository.findById(id)
                .map(artesanato -> {
                    artesanato.setNome(artesanatoDTO.nome());
                    artesanato.setDescricao(artesanatoDTO.descricao());
                    artesanato.setPreco(artesanatoDTO.preco());
                    artesanato.setQuantidade(artesanatoDTO.quantidade());
                    artesanato.setUrlImagem(artesanatoDTO.urlImagem());
                    Artesanato updatedArtesanato = artesanatoRepository.save(artesanato);
                    return artesanatoMapper.toDTO(updatedArtesanato);
                })
                .orElseThrow(() -> new RuntimeException("Artesanato não encontrado"));
    }

    public void delete(Long id) {
        Artesanato artesanato = artesanatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artesanato não encontrado"));
        artesanatoRepository.delete(artesanato);
    }
}
