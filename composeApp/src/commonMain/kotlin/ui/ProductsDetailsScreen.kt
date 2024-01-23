package ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import data.model.Product


data class ProductsDetailsScreen(val product: Product) : Screen {

    @Composable
    override fun Content() {

        Text(
            "Products Details " + product.toString()
        )
    }
}