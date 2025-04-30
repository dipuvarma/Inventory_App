package com.example.inventoryapp.data.repo

import com.example.inventoryapp.data.local.dao.ItemDao
import com.example.inventoryapp.data.local.table.Item
import com.example.inventoryapp.ui.mapper.toItemsDetails
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class InventoryRepoImpl @Inject constructor(
    private val itemDao: ItemDao,
) : InventoryRepo {

    override suspend fun insertItem(item: Item) {
        itemDao.insertItem(item)
    }

    override suspend fun updateItem(item: Item) {
        itemDao.updateItem(item)
    }

    override suspend fun deleteItem(item: Item) {
        itemDao.updateItem(item)
    }

    override suspend fun getAllItems(): Flow<List<Item>> {
        return itemDao.getAllItems()
    }

    override suspend fun getItem(id: Int): Flow<Item> {
        return itemDao.getItem(id)
    }
}