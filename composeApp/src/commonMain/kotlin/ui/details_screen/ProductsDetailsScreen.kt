package ui.details_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import coil3.compose.rememberAsyncImagePainter
import com.seiko.imageloader.rememberImagePainter
import data.model.Product


data class ProductsDetailsScreen(val product: Product) : Screen {

    @Composable
    override fun Content() {
        Surface(
            color = MaterialTheme.colors.background
        ) {

            Column(
                modifier = Modifier.fillMaxWidth()
                    .fillMaxHeight()
                    .verticalScroll(state = rememberScrollState()),
            ) {
                val painter = rememberImagePainter(product.image)
                Image(
                    painter = painter,
                    contentDescription = "image",
                    modifier = Modifier.fillMaxSize().height(400.dp).background(Color.LightGray),
                    contentScale = ContentScale.Fit,
                )

//                rememberAsyncImagePainter (
//                    model = product.image,
//                )

                Column(modifier = Modifier.padding(all = 10.dp)) {
                    Text(
                        modifier = Modifier.padding(vertical = 10.dp),
                        text = product.title,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center

                    )
                    Text(
                        modifier = Modifier.padding(bottom = 10.dp),
                        text = product.description,
                        textAlign = TextAlign.Center
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(top = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = product.category,
                            fontWeight = FontWeight.Medium,
                            fontSize = MaterialTheme.typography.body2.fontSize,

                            )

                        Text(
                            text = "$${product.price}",
                            fontWeight = FontWeight.Medium,
                            fontSize = MaterialTheme.typography.body2.fontSize,

                            )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(top = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "Rating",
                            fontWeight = FontWeight.Medium,
                            fontSize = MaterialTheme.typography.body2.fontSize,

                            )

                        Text(
                            text = "${product.rating.rate}",
                            fontWeight = FontWeight.Medium,
                            fontSize = MaterialTheme.typography.body2.fontSize,

                            )
                    }
                }
            }
        }
    }
}