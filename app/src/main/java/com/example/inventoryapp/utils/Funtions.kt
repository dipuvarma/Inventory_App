package com.example.inventoryapp.utils

import com.example.inventoryapp.data.local.table.Item
import java.text.NumberFormat


fun Item.formatedPrice(): String {
    return NumberFormat.getCurrencyInstance().format(price)
}