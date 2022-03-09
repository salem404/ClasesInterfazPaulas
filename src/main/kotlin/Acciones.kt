import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun acciones(juego:GameManager){


    //Primer bicho
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {

        Box(
            modifier = Modifier.size(60.dp)

        )
        when (juego.bicho1.tipo){
            "Agua"->{
                Image(
                    bitmap = useResource("agua.png") {
                        loadImageBitmap(it)
                    }, "Rainzu",
                    modifier = Modifier
                        .size(70.dp)
                )
            }
            "Tierra"->{
                Image(
                    bitmap = useResource("tierra.png") {
                        loadImageBitmap(it)
                    }, "Rockzu",
                    modifier = Modifier
                        .size(70.dp)
                )
            }
            "Fuego"->{
                Image(
                    bitmap = useResource("fuego.png") {
                        loadImageBitmap(it)
                    }, "Firezu",
                    modifier = Modifier
                        .size(70.dp)
                )
            }

        }

        Row {
            Text(juego.bicho1.nombre,
                fontSize = 20.sp
            )
        }


        Button(
            onClick = {juego.turno(juego.bicho1,juego.bicho2,"1")},
            shape = CutCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(230, 176, 170),
                contentColor = Color.Black
            ),
            modifier = Modifier.padding(15.dp)
        ){
            Text("Ataque normal")
        }
        Button(
            onClick = {juego.turno(juego.bicho1,juego.bicho2,"2") },
            shape = CutCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(250, 215, 160),
                contentColor = Color.Black
            ),
            modifier = Modifier.padding(15.dp)
        ){
            Text("Ataque especial")
        }
        Button(
            onClick = { juego.turno(juego.bicho1,juego.bicho2,"3") },
            shape = CutCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(215, 189, 226),
                contentColor = Color.Black
            ),
            modifier = Modifier.padding(15.dp)
        ){
            Text("Ataque descanso")
        }
        Button(
            onClick = { juego.turno(juego.bicho1,juego.bicho2,"4") },
            shape = CutCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(106,192,242),
                contentColor = Color.Black
            ),
            modifier = Modifier.padding(15.dp)
        ){
            Text("Curar")
        }
        Button(
            onClick = { juego.turno(juego.bicho1,juego.bicho2,"5") },
            shape = CutCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(182,238,166),
                contentColor = Color.Black
            ),
            modifier = Modifier.padding(15.dp)
        ){
            Text("Evolucionar")
        }
    }

    //Segundo bicho
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Top
    ) {

        Box(
            modifier = Modifier.size(60.dp)
        )
        when (juego.bicho2.tipo){
            "Agua"->{
                Image(
                    bitmap = useResource("agua.png") {
                        loadImageBitmap(it)
                    }, "Rainzu",
                    modifier = Modifier
                        .size(70.dp)
                )
            }
            "Tierra"->{
                Image(
                    bitmap = useResource("tierra.png") {
                        loadImageBitmap(it)
                    }, "Rainzu",
                    modifier = Modifier
                        .size(70.dp)
                )
            }
            "Fuego"->{
                Image(
                    bitmap = useResource("fuego.png") {
                        loadImageBitmap(it)
                    }, "Rainzu",
                    modifier = Modifier
                        .size(70.dp)
                )
            }

        }
        Text(juego.bicho2.nombre,
            fontSize = 20.sp)

        Button(
            onClick = {
                juego.turno(juego.bicho2,juego.bicho1,"1")},
            shape = CutCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(230, 176, 170),
                contentColor = Color.Black
            ),
            modifier = Modifier.padding(15.dp)
        ){
            Text("Ataque normal")
        }
        Button(
            onClick = {juego.turno(juego.bicho2,juego.bicho1,"2") },
            shape = CutCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(250, 215, 160),
                contentColor = Color.Black
            ),
            modifier = Modifier.padding(15.dp)
        ){
            Text("Ataque especial")
        }
        Button(
            onClick = { juego.turno(juego.bicho2,juego.bicho1,"3") },
            shape = CutCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(215, 189, 226),
                contentColor = Color.Black
            ),
            modifier = Modifier.padding(15.dp)
        ){
            Text("Ataque descanso")
        }
        Button(
            onClick = { juego.turno(juego.bicho2,juego.bicho1,"4") },
            shape = CutCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(106,192,242),
                contentColor = Color.Black
            ),
            modifier = Modifier.padding(15.dp)
        ){
            Text("Curar")
        }
        Button(
            onClick = { juego.turno(juego.bicho2,juego.bicho1,"5") },
            shape = CutCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(182,238,166),
                contentColor = Color.Black
            ),
            modifier = Modifier.padding(15.dp)
        ){
            Text("Evolucionar")
        }
    }

}