package com.projeto.mamaecontente.service;

import com.projeto.mamaecontente.dto.ArtesanatoDTO;
import com.projeto.mamaecontente.model.Artesanato;
import com.projeto.mamaecontente.repository.ArtesanatoRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ArtesanatoServiceTest {

    @Mock
    private ArtesanatoRepository artesanatoRepository;

    @Mock
    private ArtesanatoMapper artesanatoMapper;

    private ArtesanatoService artesanatoService;

    private ArtesanatoDTO artesanatoDTO;
    private Artesanato artesanato;

    @BeforeEach
    void setUp() {
        artesanatoService = new ArtesanatoService(artesanatoRepository, artesanatoMapper);
        artesanatoDTO = new ArtesanatoDTO(1L, "Produto 1", "Descricao 1",
                BigDecimal.TEN, 5, "");

        artesanato = new Artesanato();
        artesanato.setId(1L);
        artesanato.setNome("Produto 1");
        artesanato.setDescricao("Descricao 1");
        artesanato.setPreco(BigDecimal.valueOf(10.0));
        artesanato.setQuantidade(5);
    }

    @Test
    void shouldReturnArtesanatoDTOWhenArtesanatoIsSaved() {
        when(artesanatoMapper.toEntity(artesanatoDTO)).thenReturn(artesanato);
        when(artesanatoRepository.save(any(Artesanato.class))).thenReturn(artesanato);
        when(artesanatoMapper.toDTO(artesanato)).thenReturn(artesanatoDTO);

        ArtesanatoDTO savedArtesanato = artesanatoService.save(artesanatoDTO);

        assertEquals(artesanatoDTO, savedArtesanato);
    }

    @Test
    void shouldReturnListOfArtesanatoDTO() {
        when(artesanatoRepository.findAll()).thenReturn(List.of(artesanato));
        when(artesanatoMapper.toDTO(artesanato)).thenReturn(artesanatoDTO);

        List<ArtesanatoDTO> result = artesanatoService.findAll();

        assertEquals(1, result.size());
        assertEquals(artesanatoDTO, result.getFirst());
    }

    @Test
    void shouldReturnArtesanatoDTOWhenArtesanatoExists() {
        when(artesanatoRepository.findById(1L)).thenReturn(Optional.of(artesanato));
        when(artesanatoMapper.toDTO(artesanato)).thenReturn(artesanatoDTO);

        ArtesanatoDTO result = artesanatoService.findById(1L);

        assertEquals(artesanatoDTO, result);
    }

    @Test
    void shouldFindByIdThrowExceptionWhenArtesanatoDoesNotExist() {
        when(artesanatoRepository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() -> artesanatoService.findById(1L))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Artesanato não encontrado");
    }

    @Test
    void shouldReturnUpdatedArtesanatoDTOWhenArtesanatoExists() {
        when(artesanatoRepository.findById(1L)).thenReturn(Optional.of(artesanato));
        when(artesanatoRepository.save(any(Artesanato.class))).thenReturn(artesanato);
        when(artesanatoMapper.toDTO(artesanato)).thenReturn(artesanatoDTO);

        ArtesanatoDTO result = artesanatoService.update(1L, artesanatoDTO);

        assertEquals(artesanatoDTO, result);
    }

    @Test
    void shouldUpdateThrowExceptionWhenArtesanatoDoesNotExist() {
        when(artesanatoRepository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() -> artesanatoService.update(1L, artesanatoDTO))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Artesanato não encontrado");
    }

    @Test
    void shouldDeleteArtesanatoWhenArtesanatoExists() {
        when(artesanatoRepository.findById(1L)).thenReturn(Optional.of(artesanato));

        artesanatoService.delete(1L);

        verify(artesanatoRepository, times(1)).delete(artesanato);
    }

    @Test
    void shouldThrowExceptionWhenArtesanatoDoesNotExist() {
        when(artesanatoRepository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() -> artesanatoService.delete(1L))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Artesanato não encontrado");
    }
}
