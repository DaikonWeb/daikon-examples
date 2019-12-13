class InMemoryVegetableRepository : VegetableRepository {
    override fun save(vegetable: Vegetable) {

    }

    override fun all(): List<Vegetable> {
        return emptyList()
    }
}
