package data

import data.model.Product

sealed class ProductsListState {
    data object Idle : ProductsListState()
    data object Loading : ProductsListState()
    data class Success(val date: List<Product>) : ProductsListState()
    data class Error(val message: String) : ProductsListState()
}