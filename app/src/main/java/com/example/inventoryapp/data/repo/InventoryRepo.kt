package com.example.inventoryapp.data.repo

import com.example.inventoryapp.data.local.table.Item
import com.example.inventoryapp.ui.item.ItemDetailsUi
import kotlinx.coroutines.flow.Flow

interface InventoryRepo {

    suspend fun insertItem(item: Item)

    suspend fun updateItem(item: Item)

    suspend fun deleteItem(item: Item)

    suspend fun getAllItems(): Flow<List<Item>>

    suspend fun getItem(id: Int): Flow<Item>
}