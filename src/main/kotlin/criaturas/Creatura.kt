package criaturas

abstract class Creatura(val nombre: String,
                        var potenciaAtaque: Float,
                        var HP: Float = 100f,
                        var experiencia: Double= 0.0,
                        var defensa: Float,
                        var potenciaExtra:Float= 1f,
                        val tipo:String) {

    init {
        HP + (-15..30).random()
        defensa + (-5..5).random()
    }

    fun saludo() = println("Hola, soy $nombre y soy guay del paraguay")

    fun curar(){
        print("¡$nombre se ha curado! Vida ${HP.toInt()} -> ")
        HP += (20..100).random()
        print("${HP.toInt()}\n")
        graciasPorLaCura()
    }

    fun atacar(otroCreatura:Creatura): Float {
        println("¡$nombre ataca a ${otroCreatura.nombre}!")
        return potenciaAtaque / otroCreatura.defensa * potenciaExtra * 0.5f *((1..2).random()) + 1
    }

    fun danyoRecibido(danyo:Float){
        HP -= danyo
        println("¡${nombre} pierde ${danyo.toInt()} de vida! (${HP.toInt()} de vida restante)")
    }

    fun evolucionar(){
        print("¡$nombre ha evolucionado! Potencia de ataque ${potenciaAtaque.toInt()} -> ")
        potenciaAtaque *= 1.2f
        print("${potenciaAtaque.toInt()}\n")
    }

    fun potenciaTipo(otroCreatura: Creatura){
        val tipos= mapOf(
            "Agua" to "Fuego"
        )
        for ((key, value) in tipos){
            if (key==tipo && value==otroCreatura.tipo){
                potenciaExtra+=5f
                otroCreatura.potenciaExtra-=0.5f
            }
            if (key==otroCreatura.tipo && value==tipo){
                otroCreatura.potenciaExtra+=5f
                potenciaExtra-=0.5f
            }
        }
    }

    abstract fun ataqueEspecial()
    abstract fun ataqueDescanso()

    private fun graciasPorLaCura() = println("uwu ¡Gracias por la cura!")

    override fun toString(): String {
        return "$nombre, ${potenciaAtaque.toInt()} de ataque, vida de ${HP.toInt()}"
    }

}