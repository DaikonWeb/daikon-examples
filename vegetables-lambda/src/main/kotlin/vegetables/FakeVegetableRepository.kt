package vegetables

class FakeVegetableRepository : VegetableRepository {

    companion object {
        val vegetables = mutableListOf(
            Vegetable("Topinambur", "The Jerusalem artichoke (Helianthus tuberosus), also called sunroot, sunchoke, or earth apple, is a species of sunflower native to central North America."),
            Vegetable("Daikon", "Daikon (大根, literally 'big root'), Raphanus sativus var. longipinnatus, also known by many other names depending on context, is a mild-flavored winter radish usually characterized by fast-growing leaves and a long, white, napiform root."),
            Vegetable("Carrot", "The carrot (Daucus carota subsp. sativus) is a root vegetable, usually orange in colour, though purple, black, red, white, and yellow cultivars exist."),
            Vegetable("Garlic", "Garlic is native to Central Asia and northeastern Iran, and has long been a common seasoning worldwide, with a history of several thousand years of human consumption and use."),
            Vegetable("Pumpkin", "A pumpkin is a cultivar of winter squash that is round with smooth, slightly ribbed skin, and most often deep yellow to orange in coloration. The thick shell contains the seeds and pulp.")
        )
    }

    override fun all(): List<Vegetable> {
        return vegetables
    }

    override fun get(name: String): Vegetable {
        return vegetables.single { equalsIgnoringCase(it, name) }
    }

    private fun equalsIgnoringCase(vegetable: Vegetable, name: String) =
        vegetable.name.toLowerCase() == name.toLowerCase()
}
