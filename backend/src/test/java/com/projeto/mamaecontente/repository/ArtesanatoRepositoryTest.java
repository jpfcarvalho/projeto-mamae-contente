package com.projeto.mamaecontente.repository;

import com.projeto.mamaecontente.TestcontainersConfiguration;
import com.projeto.mamaecontente.model.Artesanato;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Optional;

import jakarta.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class ArtesanatoRepositoryTest extends TestcontainersConfiguration {

    @Autowired
    private ArtesanatoRepository artesanatoRepository;

    @Test
    void shouldSaveArtesanato() {
        Artesanato novoArtesanato = new Artesanato();
        novoArtesanato.setNome("Bolsa de Crochê");
        novoArtesanato.setDescricao("Bolsa de linha de crochê feita a mão");
        novoArtesanato.setPreco(new BigDecimal("79.90"));
        novoArtesanato.setUrlImagem("http://example.com/bolsa.jpg");

        Artesanato artesanatoSalvo = artesanatoRepository.save(novoArtesanato);

        assertThat(artesanatoSalvo).isNotNull();
        assertThat(artesanatoSalvo.getId()).isNotNull();
        assertThat(artesanatoSalvo.getNome()).isEqualTo("Bolsa de Crochê");
    }

    @Test
    void shouldFindByIdArtesanato() {
        Artesanato novoArtesanato = new Artesanato();
        novoArtesanato.setNome("Colar de Macramê");
        novoArtesanato.setDescricao("Colar com pedra da lua");
        novoArtesanato.setPreco(new BigDecimal("45.50"));
        novoArtesanato.setUrlImagem("http://example.com/colar.jpg");
        artesanatoRepository.save(novoArtesanato);

        Optional<Artesanato> artesanatoEncontrado = artesanatoRepository.findById(novoArtesanato.getId());

        assertThat(artesanatoEncontrado).isPresent();
        assertThat(artesanatoEncontrado.get().getNome()).isEqualTo("Colar de Macramê");
    }
}
