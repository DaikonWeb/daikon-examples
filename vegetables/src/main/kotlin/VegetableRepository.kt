interface VegetableRepository {
    fun add(vegetable: Vegetable)
    fun all(): List<Vegetable>
    fun empty()
    fun get(name: String): Vegetable
    fun delete(name: String)
    fun update(vegetable: Vegetable)
}
