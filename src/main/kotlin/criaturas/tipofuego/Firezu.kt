package criaturas.tipofuego

import criaturas.Creatura

class Firezu(nombre: String = "Rizu",
              potenciaAtaque: Float = 100f,
              HP: Float = 220f,
              experiencia: Double = 0.0,
              defensa: Float = 1f,
              potenciaExtra:Float= 1f,
              override var tiempoCalentar: Int = 0,
              override var temperatura: Float= 25f
) : Creatura(nombre, potenciaAtaque, HP, experiencia, defensa, potenciaExtra, tipo= "Fuego"), Fuego {

    override fun ataqueEspecial() {
        calentarfuego(1)
    }

    override fun ataqueDescanso() {
        temperaturaNormal()
    }

    override fun calentarfuego(tiempo: Int) {
        print("$nombre:")
        potenciaAtaque += 10f
        super.calentarfuego(tiempo)
    }

    override fun temperaturaNormal() {
        potenciaAtaque = 100f
        super.temperaturaNormal()
    }

}