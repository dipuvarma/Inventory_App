package com.example.inventoryapp.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.inventoryapp.R
import com.example.inventoryapp.data.local.table.Item

@Composable
fun CardItemListComp(
    modifier: Modifier = Modifier,
    item: Item
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimensionResource(R.dimen.padding_medium),
                vertical = dimensionResource(R.dimen.padding_small)
            ),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondary
        )
    ) {
        ItemListComp(
            item = item
        )
    }

}


@Composable
private fun ItemListComp(
    modifier: Modifier = Modifier,
    item: Item,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                dimensionResource(R.dimen.padding_medium)
            ),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = item.price.toString(),
                style = MaterialTheme.typography.titleMedium
            )
        }
        Text(
            text = item.quantity.toString(),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

