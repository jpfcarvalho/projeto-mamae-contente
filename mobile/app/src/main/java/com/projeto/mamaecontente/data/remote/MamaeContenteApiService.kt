package com.projeto.mamaecontente.data.remote

import com.projeto.mamaecontente.domain.model.ArtesanatoItem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface MamaeContenteApiService {

    @GET("api/artesanatos")
    suspend fun getArtesanatos(): List<ArtesanatoItem>

    @GET("api/artesanatos/{id}")
    suspend fun getArtesanatoById(@Path("id") id: Int): ArtesanatoItem

    @POST("api/artesanatos")
    suspend fun addArtesanato(@Body artesanato: ArtesanatoItem): Response<Void>

    @PUT("api/artesanatos/{id}")
    suspend fun updateArtesanato(@Path("id") id: Int, @Body artesanato: ArtesanatoItem): Response<Void>

    @DELETE("api/artesanatos/{id}")
    suspend fun deleteArtesanato(@Path("id") id: Int): Response<Void>
}
