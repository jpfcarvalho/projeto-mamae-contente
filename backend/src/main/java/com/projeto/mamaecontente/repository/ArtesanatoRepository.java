package com.projeto.mamaecontente.repository;

import com.projeto.mamaecontente.model.Artesanato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtesanatoRepository extends JpaRepository<Artesanato, Long> {
}
