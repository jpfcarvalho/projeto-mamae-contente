package com.projeto.mamaecontente.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projeto.mamaecontente.data.repository.ArtesanatoRepository
import com.projeto.mamaecontente.domain.model.ArtesanatoItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ArtesanatoListUiState(
    val isLoading: Boolean = false,
    val artesanatos: List<ArtesanatoItem> = emptyList(),
    val error: String? = null
)

data class ArtesanatoDetailUiState(
    val isLoading: Boolean = false,
    val artesanato: ArtesanatoItem? = null,
    val error: String? = null,
    val isSaved: Boolean = false
)

@HiltViewModel
class ArtesanatoViewModel @Inject constructor(
    private val repository: ArtesanatoRepository
) : ViewModel() {

    private val _listUiState = MutableStateFlow(ArtesanatoListUiState())
    val listUiState: StateFlow<ArtesanatoListUiState> = _listUiState.asStateFlow()

    private val _detailUiState = MutableStateFlow(ArtesanatoDetailUiState())
    val detailUiState: StateFlow<ArtesanatoDetailUiState> = _detailUiState.asStateFlow()

    init {
        loadArtesanatos()
    }

    fun loadArtesanatos() {
        viewModelScope.launch {
            repository.getArtesanatos()
                .onStart { _listUiState.value = ArtesanatoListUiState(isLoading = true) }
                .catch { e ->
                    _listUiState.value = ArtesanatoListUiState(error = e.message)
                }
                .collect { artesanatos ->
                    _listUiState.value = ArtesanatoListUiState(artesanatos = artesanatos)
                }
        }
    }

    fun getArtesanatoById(id: Int) {
        viewModelScope.launch {
            repository.getArtesanatoById(id)
                .onStart { _detailUiState.value = ArtesanatoDetailUiState(isLoading = true) }
                .catch { e ->
                    _detailUiState.value = ArtesanatoDetailUiState(error = e.message)
                }
                .collect { artesanato ->
                    _detailUiState.value = ArtesanatoDetailUiState(artesanato = artesanato)
                }
        }
    }

    fun addArtesanato(name: String, price: Double, quantity: Int, imageUrl: String) {
        viewModelScope.launch {
            try {
                _detailUiState.update { it.copy(isLoading = true) }
                val newItem = ArtesanatoItem(
                    id = 0,
                    name = name,
                    price = price,
                    quantity = quantity,
                    imageUrl = imageUrl
                )
                repository.addArtesanato(newItem)
                _detailUiState.update { it.copy(isLoading = false, isSaved = true) }
            } catch (e: Exception) {
                _detailUiState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }

    fun updateArtesanato(id: Int, name: String, price: Double, quantity: Int, imageUrl: String) {
        viewModelScope.launch {
            try {
                _detailUiState.update { it.copy(isLoading = true) }
                val updatedItem = ArtesanatoItem(
                    id = id,
                    name = name,
                    price = price,
                    quantity = quantity,
                    imageUrl = imageUrl
                )
                repository.updateArtesanato(updatedItem)
                _detailUiState.update { it.copy(isLoading = false, isSaved = true) }
            } catch (e: Exception) {
                _detailUiState.update { it.copy(isLoading = false, error = e.message) }
            }
        }
    }

    fun deleteArtesanato(id: Int) {
        viewModelScope.launch {
            try {
                repository.deleteArtesanato(id)
                loadArtesanatos()
            } catch (e: Exception) {
                _listUiState.value = _listUiState.value.copy(error = e.message)
            }
        }
    }
}
