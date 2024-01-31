package ui.list_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.rememberImagePainter
import data.model.Product


@Composable
fun ProductItem(product: Product, onItemClick: (Product) -> Unit) {

    Surface(

        color = MaterialTheme.colors.background,
        shape = RoundedCornerShape(size = 12.dp)
    ) {

        Column(
            modifier = Modifier.clickable {
                onItemClick(product)

            }.background(Color.LightGray),
        ) {
            val painter = rememberImagePainter(product.image)
            Image(
                painter = painter,
                contentDescription = "image",
                modifier = Modifier.fillMaxSize().height(300.dp),
                contentScale = ContentScale.Fit,

                )

            Column(modifier = Modifier.padding(all = 8.dp)) {
                Text(
                    text = "$${product.price}",
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.subtitle2.fontSize,
                    color = Color.Black
                )

                Text(
                    modifier = Modifier.padding(vertical = 8.dp),
                    text = product.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = product.category,
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.subtitle2.fontSize,
                    color = Color.Black

                )

            }
        }
    }
}