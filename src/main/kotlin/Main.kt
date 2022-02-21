// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.useResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import criaturas.Creatura
import criaturas.tipoagua.Rainzu
import criaturas.tipofuego.Firezu
import criaturas.tipotierra.Rockzu


fun main() = application {
    val icon = painterResource("peleones.png")
    Window(onCloseRequest = ::exitApplication,
            icon = icon,
            title = "uwu") {
        Box(modifier = Modifier.paint(icon).fillMaxSize()
            .background(Color.LightGray))
        encabezado()
    }
}

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

fun main2() {
    println(
        """
     --------------------------------
     Pokevones, los bichitos peleones
     --------------------------------
     1. ataque normal
     2. ataque especial
     3. descanso
     4. curar
    """.trimIndent(),
    )
    GameManager()
}

fun GameManager(){
    //Creación bichos
    val bichos = setOf<Creatura>(
        Rockzu("Patatita"),
        Rainzu("Gregorio"),
        Firezu("Despojo"),
        Rainzu(),
        Firezu(),
        Rockzu()
    )
    val bicho1= bichos.random()
    val bicho2:Creatura= bichos.random()

    bicho1.potenciaTipo(bicho2)
    println("${bicho1.nombre} VS ${bicho2.nombre}")

    //Juego principal
    while (!winner(bicho1,bicho2)){
        //seleccion de accion
        //turno de bicho1
        turno(bicho1,bicho2)
        //turno de bicho2
        turno(bicho2,bicho1)
    }
}

fun turno(uno:Creatura, dos:Creatura){
    println("\nTurno de ${uno.nombre}")
    val ataque:String = "1"
    when(ataque){
        "1"-> dos.danyoRecibido(uno.atacar(dos))
        "2" -> uno.ataqueEspecial()
        "3"-> uno.ataqueDescanso()
        "4"-> uno.curar()
        else -> uno.saludo()
    }
}

fun winner(uno:Creatura, dos:Creatura): Boolean {
    when {
        uno.HP<=0f-> {
            println("${uno.nombre} gana el combate")
            uno.saludo()
            return true
        }
        dos.HP<=0f-> {
            println("${dos.nombre} gana el combate")
            dos.saludo()
            return true
        }
    }
    return false
}