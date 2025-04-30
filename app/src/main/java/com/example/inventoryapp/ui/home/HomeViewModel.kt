package com.example.inventoryapp.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inventoryapp.data.local.table.Item
import com.example.inventoryapp.data.repo.InventoryRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val inventoryRepo: InventoryRepo,
) : ViewModel() {

    private val _homeState = MutableStateFlow(HomeUiState())
    val homeState = _homeState.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = HomeUiState()
    )

    init {
        getAllItems()
    }

    fun getAllItems() {
        viewModelScope.launch {
            _homeState.value = homeState.value.copy(
                isLoading = true
            )
            inventoryRepo.getAllItems().collect { items ->
                _homeState.value = homeState.value.copy(
                    items = items,
                    isLoading = false
                )
            }
        }
    }

}


data class HomeUiState(
    val items: List<Item> = emptyList(),
    val isLoading: Boolean = false,
)