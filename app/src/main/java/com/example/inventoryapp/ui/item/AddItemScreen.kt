package com.example.inventoryapp.ui.item

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AddItemScreen(
    modifier: Modifier = Modifier,
    viewModel: AddItemViewModel = hiltViewModel(),
) {

    LaunchedEffect(key1 = Unit) {

        viewModel.insertItem(
            itemDetails = ItemDetailsUi(
                name = "Apple",
                price = "100",
                quantity = "2"
            )
        )
    }


}