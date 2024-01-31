package data

import kotlinx.coroutines.flow.Flow
import ui.list_screen.ProductsListState

interface ProductsListService {

    fun getProductsList(): Flow<ProductsListState>

}