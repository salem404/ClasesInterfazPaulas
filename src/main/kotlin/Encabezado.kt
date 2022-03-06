import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun encabezado(){
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top,

        ) {
        Image(
            bitmap = useResource("peleones.png") {
                loadImageBitmap(it)
            }, "pelea",
            modifier = Modifier
                .size(70.dp)
        )

        Text(
            "Los bichitos peleones", fontSize = 42.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Black
        )
        Image(
            bitmap = useResource("peleones1.png") {
                loadImageBitmap(it)
            }, "pelea",
            modifier = Modifier
                .size(70.dp)
        )
    }

}
