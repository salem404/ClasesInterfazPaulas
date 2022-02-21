package criaturas.tipoagua

import criaturas.Creatura

class Rainzu(nombre: String = "Razu",
             potenciaAtaque: Float = 100f,
             HP: Float = 220f,
             experiencia: Double = 0.0,
             defensa: Float = 1f,
             potenciaExtra:Float = 1f,
             override var tiempoSumergido: Int = 0,
             override val maxResistencia: Int = 3
) : Creatura(nombre, potenciaAtaque, HP, experiencia, defensa, potenciaExtra, tipo= "Agua"), Agua {

    override fun ataqueEspecial() {
        sumergir()
    }

    override fun ataqueDescanso() {
        respirar()
    }

    override fun sumergir() {
        print("$nombre:")
        defensa += 5f
        super.sumergir()
    }

    override fun respirar() {
        print("$nombre:")
        defensa = 1f
        super.respirar()
    }
}