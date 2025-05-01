package com.example.inventoryapp.ui.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.inventoryapp.R
import com.example.inventoryapp.ui.component.TopAppBarComp
import com.example.inventoryapp.ui.navigation.AddItem

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel,
    navController: NavController,
) {

    val itemList = viewModel.homeState.collectAsState().value


    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBarComp(
                title = stringResource(R.string.app_name)
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(AddItem)
            }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        }

    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            items(itemList.items) { item ->
                CardItemListComp(
                    item = item
                )
            }
        }
    }

}