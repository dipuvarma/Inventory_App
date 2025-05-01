package com.example.inventoryapp.ui.navigation

import kotlinx.serialization.Serializable


@Serializable
object Home

@Serializable
object AddItem

@Serializable
object EditItem

@Serializable
data class DetailItem(
    val id: Int,
)
