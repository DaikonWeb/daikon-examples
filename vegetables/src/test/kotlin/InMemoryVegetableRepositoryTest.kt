import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

class InMemoryVegetableRepositoryTest {

    private val repository = InMemoryVegetableRepository()

    @AfterEach
    fun after() {
        repository.empty()
    }

    @Test
    fun `add a vegetable and get all`() {
        repository.add(Vegetable("Carrot", "so good"))

        assertThat(repository.all().single()).isEqualTo(Vegetable("Carrot", "so good"))
    }

    @Test
    fun `add a vegetable and get it`() {
        repository.add(Vegetable("Carrot", "so good"))

        assertThat(repository.get("Carrot")).isEqualTo(Vegetable("Carrot", "so good"))
    }

    @Test
    fun empty() {
        val repository = InMemoryVegetableRepository()
        repository.add(Vegetable("Carrot", "so good"))

        repository.empty()

        assertThat(repository.all()).isEmpty()
    }
}