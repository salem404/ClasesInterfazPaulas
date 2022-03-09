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
import kotlinx.coroutines.delay
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

    Window(onCloseRequest = ::exitApplication,
            icon = icon,
            title = "Bichitos peleones") {
        Box(modifier = Modifier.paint(icon).fillMaxSize()
            .background(Color(249, 248, 248)))
        encabezado()
        acciones(juego)
        pantalla(juego)
    }
}

//Pantalla abajo central que muestra las acciones y la vida

@Composable
fun pantalla(game:GameManager){
    var textoES by remember { mutableStateOf("") }
    var ganador by remember { mutableStateOf(game.winner(game.bicho1,game.bicho2)) }
    var vida1 by remember { mutableStateOf(game.bicho1.HP) }
    var vida2 by remember { mutableStateOf(game.bicho2.HP) }
    fun refrescarInterfaz() {
        textoES = game.mensaje
        ganador=game.winner(game.bicho1,game.bicho2)
        vida1=game.bicho1.HP
        vida2=game.bicho2.HP
    }
    var corutina = rememberCoroutineScope()

    corutina.launch {
        while (true){
            delay(10)
            refrescarInterfaz()
        }
         }
    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom) {
        Text(textoES)
        if (!ganador){
            Row {
                Text(vida1.toString())
                Text("   ")
                Text(vida2.toString())
            }
        }

    }


}
