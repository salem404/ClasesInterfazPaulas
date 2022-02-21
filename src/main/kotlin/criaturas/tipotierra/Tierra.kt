package criaturas.tipotierra

interface Tierra {
    var tiempoCavar:Int
    var profundidad:Int

    fun cavar(){
        when(profundidad){
            0->{
                print(" *c entierra*")
                profundidad += 1
                tiempoCavar+= 1
            }
            else->{
                profundidad += 1
                tiempoCavar +=1
                print(" *cigue abajo*\n")
            }
        }
    }

    fun superficie(){
        profundidad = 0
        print(" *c zale del abujero*\n")
    }

}