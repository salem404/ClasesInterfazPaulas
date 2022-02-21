package criaturas.tipoagua
interface Agua {
    val maxResistencia:Int //tiempo que aguantará
    var tiempoSumergido:Int //turnos que lleva sumergido

    fun sumergir(){
        when (tiempoSumergido){
            maxResistencia-> {
                print(" ¡No puc mes!\n")
                respirar()
            }
            0->{
                tiempoSumergido += 1
                print(" *c zumerge*\n")
            }
            else->{
                tiempoSumergido += 1
                print(" *cigue abajo*\n")
            }
        }
    }

    fun respirar(){
        when (tiempoSumergido){
            0-> print(" ¡No estoy bajo el agua!")
            else->{
                tiempoSumergido = 0
                print(" *c zale del awa*\n")
            }
        }
    }

}