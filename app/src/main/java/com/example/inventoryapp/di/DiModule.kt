package com.example.inventoryapp.di

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.inventoryapp.data.local.InventoryDatabase
import com.example.inventoryapp.data.repo.InventoryRepo
import com.example.inventoryapp.data.repo.InventoryRepoImpl
import com.example.inventoryapp.ui.item.AddItemViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DiModule {


    @Provides
    @Singleton
    fun getDatabase(application: Application): InventoryDatabase {
        return Room.databaseBuilder(
            application,
            InventoryDatabase::class.java,
            "inventory_db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideInventoryRepository(inventoryDatabase: InventoryDatabase): InventoryRepo {
        return InventoryRepoImpl(inventoryDatabase.getItemDao())
    }

    @Provides
    @Singleton
    fun provideAddItemViewModel(inventoryRepo: InventoryRepo): AddItemViewModel {
        return AddItemViewModel(inventoryRepo)
    }

}