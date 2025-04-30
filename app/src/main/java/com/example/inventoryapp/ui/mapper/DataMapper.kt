package com.example.inventoryapp.ui.mapper

import com.example.inventoryapp.data.local.table.Item
import com.example.inventoryapp.ui.item.AddItemUiState
import com.example.inventoryapp.ui.item.ItemDetailsUi



fun Item.toItemUiState(isEntryValid: Boolean = false): AddItemUiState = AddItemUiState(
    itemDetails = this.toItemsDetails(),
    isEntryValid = isEntryValid
)

fun Item.toItemsDetails(): ItemDetailsUi {
    return ItemDetailsUi(
        id = id!!,
        name = name,
        price = price.toString(),
        quantity = quantity.toString()
    )
}