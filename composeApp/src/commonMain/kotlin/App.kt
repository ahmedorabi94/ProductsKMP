import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.koin.compose.KoinApplication
import org.koin.core.KoinApplication
import ui.ProductsListScreen

@Composable
fun App() {

//    KoinApplication(application = {
//        modules(appModule())
//    }) {
//        MaterialTheme {
//            Navigator(ProductsListScreen())
//        }
//    }
    MaterialTheme {
        Navigator(ProductsListScreen())
    }

}