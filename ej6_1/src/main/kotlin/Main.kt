//Esta es un tipo de herencia de especialización
//He creado la super clase en abstract, luego las clases heredan la función y definen cómo la realiza
//concretamente según su clase
abstract class Felino(open val color: String){
    open fun conseguirComida(): String {
        return ""
    }
}
//Luego la subclase especializa la función de la superclase, cambiando el cómo la realiza
class Leopardo(override val color: String): Felino(color){
    override fun conseguirComida(): String{
        return "Cazando"
    }
}
//Aquí la segunda subclase de especialización
class Gato(override val color: String): Felino(color){
    override fun conseguirComida(): String{
        return "Maullando"
    }
}
//Creo que no hay otra forma de implementar una especialización que no sea con herencia
//Este tipo de herencia permite definir una clase genérica para "comportamientos" que se llevan a cabo
//por más de una clase, para luego en cada clase decir cómo lo llevan a cabo de forma concreta.
//Ahorra código para las partes que las clases realicen de la misma forma (no haría falta concretizar en ese caso)


//Esta es un tipo de herencia de extensión. Implica que el resto de clases heredan los datos y la función
// y añaden cosas, sin que implique especialización.
//Esta es la superclase.
 open class Dato(open val nombre: String){
    override fun toString(): String {
        return nombre
    }
 }
//Esta es la primera subclase
 open class DatoFormulario(override val nombre: String, open val apellidos: String): Dato(nombre)
 {
     override fun toString(): String {
         return "$nombre  $apellidos"
     }
 }
//Y esta la segunda subclase
class DNI(override val nombre: String, val DNI: String): Dato(nombre){
    override fun toString(): String {
        return "$nombre  $DNI"
    }
}
//La forma de implementar esto sin herencia sería escribir todas las clases como si fueran independientes
//con todos los datos, pero en un ejemplo más realista habría mucho código que tuvieran en común
// y por tanto implicaría repetir mucho código.
//Creo que la ventaja de usar este tipo de herencia es la misma que en las otras, que para las cosas
// que las clases vayan a realizar igual se ahorra mucho código.

fun main() {
    //Parte de poner a prueba la herencia por especialización
    val chiqui = Gato("tricolor")
    println(chiqui.conseguirComida())
    val leo = Leopardo("manchas")
    println(leo.conseguirComida())

    //Parte de poner a prueba la herencia por extensión.
    var dato = Dato("Pepe")
    var formulario = DatoFormulario("Juan","Pérez")
    var DNI = DNI("Juan","8787897U")
    println(dato)
    println(formulario)
    println(DNI)
}