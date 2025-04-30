package com.example.inventoryapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.inventoryapp.data.local.dao.ItemDao
import com.example.inventoryapp.data.local.table.Item


@Database(entities = [Item::class], version = 2)
abstract class InventoryDatabase : RoomDatabase() {

    abstract fun getItemDao(): ItemDao
}