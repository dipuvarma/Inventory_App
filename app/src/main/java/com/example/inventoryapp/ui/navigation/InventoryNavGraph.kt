package com.example.inventoryapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.inventoryapp.ui.home.HomeScreen
import com.example.inventoryapp.ui.item.AddItemScreen
import com.example.inventoryapp.ui.item.ItemDetailScreen

@Composable
fun InventoryNavGraph() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home) {

        composable<Home> {
            HomeScreen(
                viewModel = hiltViewModel(),
                navController = navController
            )
        }

        composable<AddItem> {
            AddItemScreen(
                viewModel = hiltViewModel(),
                navController = navController
            )
        }
        composable<DetailItem> {
            val args = it.toRoute<DetailItem>()
            ItemDetailScreen(
                id = args.id,
                viewModel = hiltViewModel(),
                navController = navController
            )
        }

    }

}