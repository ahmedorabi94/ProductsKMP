import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import org.jetbrains.compose.resources.ExperimentalResourceApi
import ui.ProductsListScreen

@Composable
fun App() {
    MaterialTheme {
        Navigator(ProductsListScreen())
    }
}