package com.example.inventoryapp.ui.item

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
class EditItemViewModel @Inject constructor(
    private val inventoryRepo: InventoryRepo,
) : ViewModel() {

    private val _editState = MutableStateFlow(EditItemUiState())
    val editState = _editState.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        EditItemUiState()
    )


    suspend fun getItem(id: Int) {
        viewModelScope.launch {
            inventoryRepo.getItem(id).collect { item ->
                _editState.value = editState.value.copy(
                )
            }
        }
    }


    suspend fun updateIem(item: Item) {
        viewModelScope.launch {
          inventoryRepo.updateItem(item = item)
        }
    }

}


data class EditItemUiState(
    val item: List<Item> = emptyList(),
)