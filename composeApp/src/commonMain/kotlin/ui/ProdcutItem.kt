package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.rememberImagePainter
import data.Product


@Composable
fun ProductItem(product: Product) {

    Surface(
        color = MaterialTheme.colors.background,
        shape = RoundedCornerShape(size = 12.dp)
    ) {


        Column {
            /// image

            val painter = rememberImagePainter(product.image)
            Image(
                painter = painter,
                contentDescription = "image",
            )

            Column(modifier = Modifier.padding(all = 10.dp)) {
                Text(
                    modifier = Modifier.padding(vertical = 10.dp),
                    text = product.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier.padding(bottom = 10.dp),
                    text = product.description,
                    maxLines = 6,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(top = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    // chip
                    Text(
                        text = "${product.price}",
                        fontWeight = FontWeight.Medium,
                        fontSize = MaterialTheme.typography.body2.fontSize,

                        )
                }
            }
        }
    }
}