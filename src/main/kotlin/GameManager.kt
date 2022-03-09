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
        when(ataque){
            "1"-> {
                dos.danyoRecibido(uno.atacar(dos))
                mensaje= "¡${uno.nombre} ataca a ${dos.nombre}!"
            }
            "2" -> {
                uno.ataqueEspecial()
                when (uno.tipo){
                    "Agua"-> mensaje="${uno.nombre} *c zumerge*"
                    "Fuego"-> mensaje="${uno.nombre} *c cabrea*"
                    "Tierra"-> mensaje="${uno.nombre} *c entierra*"
                }
            }
            "3"-> {
                uno.ataqueDescanso()
                when (uno.tipo){
                    "Agua"-> mensaje="${uno.nombre} *c zale del awa*"
                    "Fuego"-> mensaje="${uno.nombre} *c relaja*"
                    "Tierra"-> mensaje="${uno.nombre} *c zale del bujero*"
                }
            }
            "4"-> {
                uno.curar()
                mensaje="¡${uno.nombre} se ha curado! Vida ${uno.HP.toInt()}"
            }
            "5"-> {
                uno.evolucionar()
                mensaje="¡${uno.nombre} ha evolucionado!"
            }
        }
        winner(uno,dos)
    }

    fun winner(uno:Creatura, dos:Creatura): Boolean {
        if (uno.HP<=0f) {
                println("${dos.nombre} gana el combate")
                mensaje="${dos.nombre} gana el combate"
                dos.saludo()
                return true
            }else if(dos.HP<=0f){
                println("${uno.nombre} gana el combate")
                mensaje="${uno.nombre} gana el combate"
                uno.saludo()
                return true
            }else{ return false}

    }
}