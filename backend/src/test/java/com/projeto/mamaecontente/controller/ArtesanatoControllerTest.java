package com.projeto.mamaecontente.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projeto.mamaecontente.dto.ArtesanatoDTO;
import com.projeto.mamaecontente.service.ArtesanatoService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = ArtesanatoController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class ArtesanatoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ArtesanatoService artesanatoService;

    @Autowired
    private ObjectMapper objectMapper;

    private ArtesanatoDTO artesanatoDTO;

    @BeforeEach
    void setUp() {
        artesanatoDTO = new ArtesanatoDTO(1L, "Produto 1", "Descricao 1",
                BigDecimal.TEN, 5, "");
    }

    @Test
    void shouldReturnListOfArtesanatoDTO() throws Exception {
        List<ArtesanatoDTO> artesanatos = Collections.singletonList(artesanatoDTO);
        when(artesanatoService.findAll()).thenReturn(artesanatos);

        mockMvc.perform(get("/api/artesanatos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Produto 1"));
    }

    @Test
    void shouldReturnArtesanatoDTO() throws Exception {
        when(artesanatoService.findById(1L)).thenReturn(artesanatoDTO);

        mockMvc.perform(get("/api/artesanatos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Produto 1"));
    }

    @Test
    void shouldSaveReturnArtesanatoDTO() throws Exception {
        when(artesanatoService.save(any(ArtesanatoDTO.class))).thenReturn(artesanatoDTO);

        mockMvc.perform(post("/api/artesanatos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(artesanatoDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Produto 1"));
    }

    @Test
    void shouldUpdateReturnArtesanatoDTO() throws Exception {
        when(artesanatoService.update(any(Long.class), any(ArtesanatoDTO.class))).thenReturn(artesanatoDTO);

        mockMvc.perform(put("/api/artesanatos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(artesanatoDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Produto 1"));
    }

    @Test
    void shouldReturnNoContent() throws Exception {
        mockMvc.perform(delete("/api/artesanatos/1"))
                .andExpect(status().isNoContent());
    }
}
