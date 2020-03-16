package vegetables

interface VegetableRepository {
    fun all(): List<Vegetable>
    fun get(name: String): Vegetable
}
