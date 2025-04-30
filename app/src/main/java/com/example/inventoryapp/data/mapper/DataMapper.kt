package com.example.inventoryapp.data.mapper

import com.example.inventoryapp.data.local.table.Item
import com.example.inventoryapp.ui.item.ItemDetailsUi


fun ItemDetailsUi.toItem(): Item {
    return Item(
        id = id,
        name = name,
        price = price.toDoubleOrNull() ?: 0.0,
        quantity = quantity.toIntOrNull() ?: 0
    )
}


