package com.example.inventoryapp.ui.item

import android.util.Log
import android.view.View
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inventoryapp.data.repo.InventoryRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ItemDetailViewModel @Inject constructor(
    val repository: InventoryRepo,
) : ViewModel() {

    private val _itemDetailState = MutableStateFlow(ItemDetailUiState())
    val itemDetailState = _itemDetailState.asStateFlow()

//    init {
//        viewModelScope.launch {
//            getItemById(3)
//        }
//    }

    suspend fun getItemById(id: Int) {
        viewModelScope.launch {
            repository.getItem(id).collect { item ->
                _itemDetailState.value = itemDetailState.value.copy(
                    name = item.name,
                    price = item.price,
                    quantity = item.quantity
                )
            }
        }
    }


}


data class ItemDetailUiState(
    val id: Int = 0,
    val name: String = "",
    val price: Double = 0.0,
    val quantity: Int = 0,
)