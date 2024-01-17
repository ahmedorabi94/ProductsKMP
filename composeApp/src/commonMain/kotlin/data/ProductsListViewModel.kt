package data

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ProductsListViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<ProductsListState>(ProductsListState.Idle)
    val uiState = _uiState.asStateFlow()

    private val productsListApi = ProductsListApi()

    init {
        viewModelScope.launch {
            productsListApi.getProductsList(10).collectLatest {
                _uiState.value = it
            }

        }
    }
}