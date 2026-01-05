package com.projeto.mamaecontente.controller;

import com.projeto.mamaecontente.dto.ArtesanatoDTO;
import com.projeto.mamaecontente.service.ArtesanatoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/artesanatos")
@AllArgsConstructor
public class ArtesanatoController {

    private ArtesanatoService artesanatoService;

    @GetMapping
    public List<ArtesanatoDTO> findAll() {
        return artesanatoService.findAll();
    }

    @GetMapping("/{id}")
    public ArtesanatoDTO findById(@PathVariable Long id) {
        return artesanatoService.findById(id);
    }

    @PostMapping
    public ArtesanatoDTO save(@RequestBody ArtesanatoDTO artesanatoDTO) {
        return artesanatoService.save(artesanatoDTO);
    }

    @PutMapping("/{id}")
    public ArtesanatoDTO update(@PathVariable Long id, @RequestBody ArtesanatoDTO artesanatoDTO) {
        return artesanatoService.update(id, artesanatoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        artesanatoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
