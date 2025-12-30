package com.projeto.mamaecontente.data.repository

import com.projeto.mamaecontente.domain.model.ArtesanatoItem
import kotlinx.coroutines.flow.Flow

interface ArtesanatoRepository {

    fun getArtesanatos(): Flow<List<ArtesanatoItem>>

    fun getArtesanatoById(id: Int): Flow<ArtesanatoItem?>

    suspend fun addArtesanato(artesanato: ArtesanatoItem)

    suspend fun updateArtesanato(artesanato: ArtesanatoItem)

    suspend fun deleteArtesanato(id: Int)
}
