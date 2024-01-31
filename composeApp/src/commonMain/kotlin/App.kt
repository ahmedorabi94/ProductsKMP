import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import di.appModule
import org.koin.compose.KoinApplication
import ui.list_screen.ProductsListScreen

@Composable
fun App() {

    KoinApplication(application = {
        modules(appModule())
    }) {
        MaterialTheme {
            Navigator(ProductsListScreen())
        }
    }

}