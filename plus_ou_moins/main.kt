import java.io.Console

fun main() {
    println("Début de la partie")
    println("Joueur 1 : Veuillez entrer un nombre entre 1 et 100 :")
    
    //Variables
    val console : Console? = System.console()
    var numberJ1PW : CharArray
    var numberJ1 : Int
    var trial : Int = 0

    try {
        numberJ1PW = console!!.readPassword("")
        numberJ1 = numberJ1PW.joinToString(separator = "").toInt()
    }
    catch (exception: KotlinNullPointerException ){
        numberJ1 = readLine()!!.toInt()
    }

    // debut de la boucle 
    var playing : Boolean = true

    if ( numberJ1 in 1..100){
        println("Joueur 2 : Devine le nombre qu'a entré Joueur 1 entre 1 et 100 ")
        println("Pour abandonner écrire 'ff' ")

        while (playing == true){
            var read = readLine()

            // Abandon de la partie
            if (read == "ff") { 
                println("Vous avez abandonné la partie !")
                System.exit(0)
                return
            }

            var numberJ2 : Int    = Integer.parseInt(read)
            println("Tu as entré : $numberJ2")

            // chaud ou froid et vérification des valeurs 
            when {
                // froid et + 
                numberJ1 > numberJ2 && kotlin.math.abs(numberJ2-numberJ1) >= 10 -> { 
                    println("T'es froid ! c'est +")
                    trial++
                    println("Essai numéro : $trial")
                }

                // chaud et + 
                numberJ1 > numberJ2 &&  kotlin.math.abs(numberJ2 - numberJ1) <= 10 -> {
                    println("C'est +, tu chauufes !")
                    trial++
                    println("Essai numéro : $trial")
                }
                
                // froid et -
                numberJ1 < numberJ2 && kotlin.math.abs(numberJ2-numberJ1) >= 10 -> {
                    println("T'es froid ! c'est -")
                    trial++
                    println("Essai numéro : $trial")
                }

                // chaud et -
                numberJ1 < numberJ2 && kotlin.math.abs(numberJ2-numberJ1) <= 10 -> {
                    println("C'est +, tu chauffes !")
                    trial++
                    println("Essai numéro : $trial")
                }

                // quand le nombre entré est le bon 
                numberJ1 == numberJ2 ->{
                    println("Gagné !")
                    trial++
                    println("Tu as réussi en $trial essai")
                    System.exit(0)
                }
            }
        }
    }
    
    else{
        println("Tu dois entrer un nombre entre 1 et 100 !")
        System.exit(0)
    }
}