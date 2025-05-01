package com.example.inventoryapp.ui.item

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.inventoryapp.R
import com.example.inventoryapp.ui.component.TopAppBarComp
import com.example.inventoryapp.ui.navigation.EditItem
import com.example.inventoryapp.ui.navigation.Home

@Composable
fun ItemDetailScreen(
    id: Int,
    viewModel: ItemDetailViewModel,
    navController: NavController
) {

    val itemDetails = viewModel.itemDetailState.collectAsState().value

    LaunchedEffect(key1 = Unit) {
        viewModel.getItemById(id = id)
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBarComp(
            title = stringResource(R.string.details_item_title),
            navigationIcon = Icons.AutoMirrored.Filled.ArrowBack,
            onNavigationClick = {
                navController.popBackStack()
            }
        )
        ItemDetailBodyComp(
            itemDetailsUi = itemDetails
        )
    }

}

@Composable
fun ItemDetailBodyComp(

    itemDetailsUi: ItemDetailUiState,
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(
                horizontal = dimensionResource(R.dimen.padding_large),
                vertical = dimensionResource(R.dimen.padding_extra_large)
            ),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_large))
    ) {
        ItemDetailComp(itemDetailsUi)
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = stringResource(R.string.sell_btn))
        }
        OutlinedButton(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium
        ) {
            Text(text = stringResource(R.string.delete_btn))
        }
    }

}

@Composable
fun ItemDetailComp(
    itemDetailsUi: ItemDetailUiState,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondary
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = dimensionResource(R.dimen.padding_large),
                    vertical = dimensionResource(R.dimen.padding_medium)
                ),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium))
        ) {
            ItemDetailRowComp(
                labelResId = R.string.item,
                itemDetail = itemDetailsUi.name
            )
            HorizontalDivider(thickness = 2.dp)
            ItemDetailRowComp(
                labelResId = R.string.quantity_in_stock,
                itemDetail = itemDetailsUi.quantity.toString()
            )
            HorizontalDivider(thickness = 2.dp)
            ItemDetailRowComp(
                labelResId = R.string.price,
                itemDetail = itemDetailsUi.price.toString()
            )
        }
    }
}


@Composable
fun ItemDetailRowComp(
    @StringRes labelResId: Int,
    itemDetail: String,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {

        Text(
            text = stringResource(labelResId),
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = itemDetail,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.SemiBold
        )

    }
}