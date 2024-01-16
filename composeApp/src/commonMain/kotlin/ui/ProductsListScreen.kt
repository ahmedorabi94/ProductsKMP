package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.Product
import data.ProductsListState
import data.ProductsListViewModel
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import io.ktor.util.logging.Logger


@Composable
fun ProductsListScreen() {

    val viewModel: ProductsListViewModel =
        getViewModel(Unit, viewModelFactory { ProductsListViewModel() })

    val uiState = viewModel.uiState.collectAsState()

    when(uiState.value){
        is ProductsListState.Error ->{

        }
        ProductsListState.Idle -> {

        }
        ProductsListState.Loading -> {

        }
        is ProductsListState.Success -> {

            LazyColumn(
                modifier = Modifier.background(MaterialTheme.colors.surface)
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(
                    items = (uiState.value as ProductsListState.Success).date.items,
                    key = { it.id }
                ) {
                    ProductItem(it)
                }
            }
        }
    }


}