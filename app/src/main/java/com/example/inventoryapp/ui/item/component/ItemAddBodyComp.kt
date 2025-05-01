package com.example.inventoryapp.ui.item.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.inventoryapp.R
import com.example.inventoryapp.ui.item.AddItemScreen
import com.example.inventoryapp.ui.item.AddItemUiState
import com.example.inventoryapp.ui.item.ItemDetailsUi
import com.example.inventoryapp.ui.theme.InventoryAppTheme


@Composable
fun ItemAddBodyComp(
    modifier: Modifier = Modifier,
    addItemUiState: AddItemUiState,
    onItemValueChange: (ItemDetailsUi) -> Unit,
    onSaveClick: () -> Unit,
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.padding_large)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_large))
    ) {
        ItemInputFormComp(
            modifier = Modifier.fillMaxWidth(),
            itemDetailsUi = addItemUiState.itemDetails,
            onValueChange = onItemValueChange,
        )
        Button(
            onClick = { onSaveClick() },
            enabled = addItemUiState.isEntryValid,
            modifier = Modifier
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(
                text = stringResource(R.string.save_btn),
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ItemEntryScreenPreview() {
    InventoryAppTheme {
        ItemAddBodyComp(
            addItemUiState = AddItemUiState(
                itemDetails = ItemDetailsUi(
                    name = "Item name",
                    price = "10.00",
                    quantity = "5"
                )
            ),
            onItemValueChange = { },
            onSaveClick = { }
        )
    }
}