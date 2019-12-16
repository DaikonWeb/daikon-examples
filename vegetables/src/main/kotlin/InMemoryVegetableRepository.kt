class InMemoryVegetableRepository : VegetableRepository {

    companion object {
        val vegetables = mutableListOf<Vegetable>()
    }

    override fun add(vegetable: Vegetable) {
        vegetables.add(vegetable)
    }

    override fun all(): List<Vegetable> {
        return vegetables
    }

    override fun empty() {
        vegetables.clear()
    }

    override fun get(name: String): Vegetable {
        return vegetables.single { it.name == name }
    }

    override fun delete(name: String) {
        vegetables.removeIf {it.name == name}
    }
}