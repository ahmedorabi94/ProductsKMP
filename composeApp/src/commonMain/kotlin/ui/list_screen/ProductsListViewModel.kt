package ui.list_screen

import data.ProductsListServiceImpl
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ProductsListViewModel : ViewModel() , KoinComponent {

    private val _uiState = MutableStateFlow<ProductsListState>(ProductsListState.Idle)
    val uiState = _uiState.asStateFlow()

    //   private val productsListApi = ProductsListApi()

    //  val myService = koinInject<ProductsListApi>()

     private val productsListApi : ProductsListServiceImpl by inject()

    init {
        viewModelScope.launch {
            productsListApi.getProductsList().collectLatest {
                _uiState.value = it
            }

        }
    }
}