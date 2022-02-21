package criaturas.tipofuego

interface Fuego {
    var temperatura:Float
    var tiempoCalentar:Int

    fun calentarfuego(tiempo:Int){
        if (tiempo==tiempoCalentar){
            temperaturaNormal()
        }else{
            temperatura+=1.2f
            print(" se esta rifando una ostia... ${temperatura.toInt()} ºC\n")
            tiempoCalentar+=1
        }
    }
    fun temperaturaNormal(){
        temperatura=25f
        print(" *c calma* ${temperatura.toInt()} ºC\n")
        tiempoCalentar=0
    }
}