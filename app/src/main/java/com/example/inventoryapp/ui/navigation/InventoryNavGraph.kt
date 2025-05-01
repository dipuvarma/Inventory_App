package com.example.inventoryapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import com.example.inventoryapp.ui.home.HomeScreen
import com.example.inventoryapp.ui.home.HomeUiState
import com.example.inventoryapp.ui.item.AddItemScreen

@Composable
fun InventoryNavGraph() {


    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home){

        composable<Home> {
            HomeScreen(
                viewModel = hiltViewModel(),
                navController = navController
            )
        }

        composable < AddItem>{
            AddItemScreen(
                viewModel = hiltViewModel(),
                navController = navController
            )
        }

    }

}