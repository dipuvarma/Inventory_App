package com.example.inventoryapp.ui.item.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.example.inventoryapp.R
import com.example.inventoryapp.ui.item.ItemDetailsUi
import java.util.Currency
import java.util.Locale

@Composable
fun ItemInputFormComp(
    modifier: Modifier = Modifier,
    itemDetailsUi: ItemDetailsUi,
    onValueChange: (ItemDetailsUi) -> Unit = {},
    enable: Boolean = true,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
    ) {
        OutlinedTextField(
            value = itemDetailsUi.name,
            onValueChange = { onValueChange(itemDetailsUi.copy(name = it)) },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = stringResource(R.string.item_name))
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                focusedTextColor = MaterialTheme.colorScheme.onSecondaryContainer,
                unfocusedTextColor = MaterialTheme.colorScheme.onSecondaryContainer,
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),

            singleLine = true,
            enabled = enable,
            shape = MaterialTheme.shapes.medium

        )
        OutlinedTextField(
            value = itemDetailsUi.price,
            onValueChange = { onValueChange(itemDetailsUi.copy(price = it)) },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = stringResource(R.string.item_price))
            },
            leadingIcon = {
                Text(text = Currency.getInstance(Locale.getDefault()).symbol)
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                focusedTextColor = MaterialTheme.colorScheme.onSecondaryContainer,
                unfocusedTextColor = MaterialTheme.colorScheme.onSecondaryContainer,
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            singleLine = true,
            enabled = enable,
            shape = MaterialTheme.shapes.medium
        )

        OutlinedTextField(
            value = itemDetailsUi.quantity,
            onValueChange = { onValueChange(itemDetailsUi.copy(quantity = it)) },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = stringResource(R.string.quantity_in_stock))
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                focusedTextColor = MaterialTheme.colorScheme.onSecondaryContainer,
                unfocusedTextColor = MaterialTheme.colorScheme.onSecondaryContainer,
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),

            singleLine = true,
            enabled = enable,
            shape = MaterialTheme.shapes.medium
        )
        if (enable) {
            Text(
                text = stringResource(R.string.required_fields),
                style = MaterialTheme.typography.bodySmall.copy(
                    color = MaterialTheme.colorScheme.error
                )
            )
        }
    }
}