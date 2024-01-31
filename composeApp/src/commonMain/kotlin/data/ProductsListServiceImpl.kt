package data

import co.touchlab.kermit.Logger
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ui.list_screen.ProductsListState

class ProductsListServiceImpl(private val httpClient: HttpClient) : ProductsListService{

    override fun getProductsList(): Flow<ProductsListState> {
        return flow {
            emit(ProductsListState.Loading)
            Logger.e { "Loading " }
            try {
                emit(
                    ProductsListState.Success(
                        date = httpClient.get(urlString = "https://fakestoreapi.com/products")
                            .body()
                    )
                )

            } catch (e: Exception) {
                Logger.e { "Error ${e.message}" }
                emit(ProductsListState.Error(e.message ?: "unknown error"))
            }
        }
    }

}