package data

import co.touchlab.kermit.Logger
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.json.Json

class ProductsListApi {

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                explicitNulls = false
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    fun getProductsList(limit: Int): Flow<ProductsListState> {
        return flow {
            emit(ProductsListState.Loading)
            Logger.e {"Loading "}
            delay(2000)
            try {


//              val items = httpClient.get(urlString = "https://fakestoreapi.com/products?limit=10").body<List<Product>>()
//                Logger.e {"items $items"}

                emit(
                    ProductsListState.Success(
                        date = httpClient.get(urlString = "https://fakestoreapi.com/products?limit=10").body()

                    )
                )

            } catch (e: Exception) {
                Logger.e {"Error ${e.message}"}
                emit(ProductsListState.Error(e.message ?: "unknown error"))
            }
        }
    }

}