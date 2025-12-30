package com.projeto.mamaecontente.data.repository

import com.projeto.mamaecontente.data.remote.MamaeContenteApiService
import com.projeto.mamaecontente.domain.model.ArtesanatoItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ArtesanatoRepositoryImpl @Inject constructor(
    private val apiService: MamaeContenteApiService
) : ArtesanatoRepository {

    override fun getArtesanatos(): Flow<List<ArtesanatoItem>> = flow {
        val artesanatos = apiService.getArtesanatos()
        emit(artesanatos)
    }

    override fun getArtesanatoById(id: Int): Flow<ArtesanatoItem?> = flow {
        val artesanato = apiService.getArtesanatoById(id)
        emit(artesanato)
    }

    override suspend fun addArtesanato(artesanato: ArtesanatoItem) {
        apiService.addArtesanato(artesanato)
    }

    override suspend fun updateArtesanato(artesanato: ArtesanatoItem) {
        apiService.updateArtesanato(artesanato.id, artesanato)
    }

    override suspend fun deleteArtesanato(id: Int) {
        apiService.deleteArtesanato(id)
    }
}
