package com.projeto.mamaecontente.data.remote

import com.projeto.mamaecontente.domain.model.ArtesanatoItem
import kotlinx.coroutines.delay
import retrofit2.Response

class FakeMamaeContenteApiService : MamaeContenteApiService {

    private val artesanatos = mutableListOf(
        ArtesanatoItem(1, "Porta Pratos", 59.90, 5, "https://picsum.photos/seed/portapratos/300"),
        ArtesanatoItem(2, "Coraçãozinhos", 9.90, 25, "https://picsum.photos/seed/coracao/300"),
        ArtesanatoItem(3, "Coruja", 19.90, 9, "https://picsum.photos/seed/coruja/300"),
        ArtesanatoItem(4, "Flor de Caneta", 15.90, 15, "https://picsum.photos/seed/flordecaneta/300"),
        ArtesanatoItem(5, "Tapete", 39.90, 5, "https://picsum.photos/seed/tapete/300")
    )

    override suspend fun getArtesanatos(): List<ArtesanatoItem> {
        delay(1000)
        return artesanatos
    }

    override suspend fun getArtesanatoById(id: Int): ArtesanatoItem {
        delay(500)
        return artesanatos.first { it.id == id }
    }

    override suspend fun addArtesanato(artesanato: ArtesanatoItem): Response<Void> {
        delay(500)
        artesanatos.add(artesanato.copy(id = (artesanatos.maxOfOrNull { it.id } ?: 0) + 1))
        return Response.success(null)
    }

    override suspend fun updateArtesanato(id: Int, artesanato: ArtesanatoItem): Response<Void> {
        delay(500)
        val index = artesanatos.indexOfFirst { it.id == id }
        if (index != -1) {
            artesanatos[index] = artesanato
        }
        return Response.success(null)
    }

    override suspend fun deleteArtesanato(id: Int): Response<Void> {
        delay(500)
        artesanatos.removeAll { it.id == id }
        return Response.success(null)
    }
}
