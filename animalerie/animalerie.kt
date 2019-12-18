// Liste
var animaux : ArrayList<Animal> = ArrayList<Animal>()

// Entrée 
fun main() {
    add(Chat())
    add(Chien())
    add(Serpent())
    add(Pigeon())

    println("Animaux : ")
    affiche()
}

// Ajouter
fun add(animal : Animal) {
    animaux.add(animal)
}

// Afficher
fun affiche() {
    for (animal in animaux) {
        animal.parler()
        animal.quiSuisJe()
    }
}