interface VegetableRepository {
    fun save(vegetable: Vegetable)
    fun all(): List<Vegetable>
}
