package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import data.ProductsListState
import data.ProductsListViewModel
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory


@Composable
fun ProductsListScreen() {

    val viewModel: ProductsListViewModel =
        getViewModel(Unit, viewModelFactory { ProductsListViewModel() })

    val uiState = viewModel.uiState.collectAsState()

    when (uiState.value) {
        is ProductsListState.Error -> {
            Box(
                modifier = Modifier.fillMaxWidth().background(MaterialTheme.colors.surface),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Error Message",
                    textAlign = TextAlign.Center
                )
            }
        }

        ProductsListState.Idle -> {

        }

        ProductsListState.Loading -> {
            Box(
                modifier = Modifier.fillMaxWidth().background(MaterialTheme.colors.surface),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is ProductsListState.Success -> {

            LazyColumn(
                modifier = Modifier.background(MaterialTheme.colors.surface)
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(
                    items = (uiState.value as ProductsListState.Success).date,
                    key = { it.id }
                ) {
                    ProductItem(it)
                }
            }
        }
    }


}