package com.example.inventoryapp.ui.item

import android.util.Log
import androidx.compose.runtime.LaunchedEffect
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

    private val _addItemState = MutableStateFlow(AddItemUiState())
    val addItemState = _addItemState.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        AddItemUiState()
    )


    fun insertItem(
        itemDetails: ItemDetailsUi,
    ) {
        viewModelScope.launch {
            repository.insertItem(
                item = itemDetails.toItem()
            )
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

