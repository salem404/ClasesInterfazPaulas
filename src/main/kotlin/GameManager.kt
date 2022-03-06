import criaturas.Creatura
import criaturas.tipoagua.Rainzu
import criaturas.tipofuego.Firezu
import criaturas.tipotierra.Rockzu

class GameManager(var bicho1:Creatura,
                  var bicho2:Creatura,
                  var mensaje:String = "${bicho1.nombre} VS ${bicho2.nombre}") {

    init {
        bicho1.potenciaTipo(bicho2)
    }


    fun turno(uno:Creatura, dos:Creatura,ataque:String){
        println("\nTurno de ${uno.nombre}")
        mensaje="Turno de ${uno.nombre}"
        when(ataque){
            "1"-> dos.danyoRecibido(uno.atacar(dos))
            "2" -> uno.ataqueEspecial()
            "3"-> uno.ataqueDescanso()
            "4"-> uno.curar()
            "5"-> uno.evolucionar()
            else -> uno.saludo()
        }
        winner(uno,dos)
    }

    fun winner(uno:Creatura, dos:Creatura): Boolean {
        when {
            uno.HP<=0f-> {
                println("${uno.nombre} gana el combate")
                mensaje="${uno.nombre} gana el combate"
                uno.saludo()
                return true
            }
            dos.HP<=0f-> {
                println("${dos.nombre} gana el combate")
                mensaje="${dos.nombre} gana el combate"
                dos.saludo()
                return true
            }
        }
        return false
    }
}