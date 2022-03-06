// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.material.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import criaturas.Creatura
import criaturas.tipoagua.Rainzu
import criaturas.tipofuego.Firezu
import criaturas.tipotierra.Rockzu
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


fun main() = application {
    val icon = painterResource("peleones.png")
    val bichos = mutableListOf<Creatura>(
        Rockzu("Patatita"),
        Rainzu("Gregorio"),
        Firezu("Despojo"),
        Rainzu(),
        Firezu(),
        Rockzu()
    )
    val juego = GameManager(bicho1 = bichos.random(),
                            bicho2 = bichos.random())
    while (juego.bicho1==juego.bicho2){
        juego.bicho2 = bichos.random()
    }

    var ganador by remember { mutableStateOf(juego.winner(juego.bicho1,juego.bicho2)) }
    var corutina = rememberCoroutineScope()

    fun refrescarInterfaz() {
        ganador = juego.winner(juego.bicho1,juego.bicho2)
    }

    Window(onCloseRequest = ::exitApplication,
            icon = icon,
            title = "Bichitos peleones") {
        Box(modifier = Modifier.paint(icon).fillMaxSize()
            .background(Color(249, 248, 248)))
        encabezado()
        acciones(juego)
        refrescarInterfaz()
        if (ganador){
            Text("Lol")
            exitApplication()
        }
        else{corutina.launch(){
            refrescarInterfaz()
        }
        }
        pantalla(juego)

    }
}


@Composable
fun pantalla(game:GameManager){
    var texto = game.mensaje
    when(game.mensaje){
        ""-> texto= "${game.bicho1.nombre} VS ${game.bicho2.nombre}"
        else->{
            texto= game.mensaje
        }
    }
    fun refrescarInterfaz() {
        texto = game.mensaje
    }

    Text(texto)

}
