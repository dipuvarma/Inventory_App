package com.example.inventoryapp.ui.item

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.inventoryapp.R
import com.example.inventoryapp.ui.component.TopAppBarComp
import com.example.inventoryapp.ui.item.component.ItemAddBodyComp
import com.example.inventoryapp.ui.theme.InventoryAppTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


@Composable
fun AddItemScreen(
    modifier: Modifier = Modifier,
    viewModel: AddItemViewModel,
    navController: NavController,
) {

    val scope = rememberCoroutineScope()
    val items = viewModel.itemUiState.isEntryValid
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBarComp(
            title = stringResource(R.string.add_item_title),
            navigationIcon = Icons.AutoMirrored.Filled.ArrowBack,
            onNavigationClick = {
                navController.navigateUp()
            }
        )
        ItemAddBodyComp(
            addItemUiState = viewModel.itemUiState,
            onItemValueChange = {
                viewModel.updateUiState(it)
            },
            onSaveClick = {
                scope.launch {
                    viewModel.saveItem()
                }
                navController.popBackStack()
            },
        )
    }

}