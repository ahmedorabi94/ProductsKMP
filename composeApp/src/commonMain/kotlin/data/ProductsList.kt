package data

import kotlinx.coroutines.flow.Flow

interface ProductsList {

    fun getProductsList(): Flow<ProductsListState>

}