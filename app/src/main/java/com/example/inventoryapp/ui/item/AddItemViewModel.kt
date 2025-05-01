package com.example.inventoryapp.ui.item

import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inventoryapp.data.local.table.Item
import com.example.inventoryapp.data.mapper.toItem
import com.example.inventoryapp.data.repo.InventoryRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AddItemViewModel @Inject constructor(
    private val repository: InventoryRepo,
) : ViewModel() {

    var itemUiState by mutableStateOf(AddItemUiState())
        private set

    suspend fun saveItem() {
        if (isValidForm()) {
            repository.insertItem(itemUiState.itemDetails.toItem())
        }
    }

    fun updateUiState(itemDetails: ItemDetailsUi) {
        itemUiState =
            AddItemUiState(itemDetails = itemDetails, isEntryValid = isValidForm(itemDetails))
    }

    fun isValidForm(uiState: ItemDetailsUi = itemUiState.itemDetails): Boolean {
        return with(uiState) {
            name.isNotBlank() && price.isNotBlank() && quantity.isNotBlank()
        }
    }

}


data class AddItemUiState(
    val itemDetails: ItemDetailsUi = ItemDetailsUi(),
    val isEntryValid: Boolean = false,
)

data class ItemDetailsUi(
    val id: Int = 0,
    val name: String = "",
    val price: String = "",
    val quantity: String = "",
)

