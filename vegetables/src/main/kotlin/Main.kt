fun main() {
    val repository = InMemoryVegetableRepository()
    repository.add(Vegetable("Carrot", "The orange one"))
    repository.add(Vegetable("Daikon", "the healthiest"))
    repository.add(Vegetable("Onion", "The most tasty"))
    repository.add(Vegetable("Garlic", "Useful against vampires"))

    Vegetables(repository).start()
}