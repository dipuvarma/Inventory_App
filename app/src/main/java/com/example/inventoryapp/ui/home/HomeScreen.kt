package com.example.inventoryapp.ui.home

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val items = viewModel.homeState.collectAsState().value

   items.items.forEach {
        Log.d("TAG", "HomeScreen: ${it.name}")
    }
    
}