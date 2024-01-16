package data

sealed class ProductsListState {
    data object Idle : ProductsListState()
    data object Loading : ProductsListState()
    data class Success(val date: Products) : ProductsListState()
    data class Error(val message: String) : ProductsListState()
}