package criaturas.tipotierra

import criaturas.Creatura

class Rockzu(nombre: String = "Rockzu",
             potenciaAtaque: Float = 100f,
             HP: Float = 220f,
             experiencia: Double = 0.0,
             defensa: Float = 1f,
             potenciaExtra:Float = 1f,
             override var tiempoCavar: Int=0,
             override var profundidad: Int=0
) : Creatura(nombre, potenciaAtaque, HP, experiencia, defensa, potenciaExtra, tipo = "Tierra"), Tierra {

    override fun ataqueEspecial() {
        cavar()
    }

    override fun ataqueDescanso() {
        superficie()
    }

    override fun cavar() {
        print("$nombre:")
        defensa += 5f
        super.cavar()
    }

    override fun superficie() {
        print("$nombre:")
        defensa = 1f
        super.superficie()
    }

}