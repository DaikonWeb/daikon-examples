import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import daikon.Request
import daikon.Response
import org.junit.jupiter.api.Test
import org.mockito.Mockito.contains

class BoxPageTest {

    private val request: Request = mock()
    private val response: Response = mock()
    private val repository: VegetableRepository = mock()

    @Test
    fun `show list`() {
        whenever(repository.all()).thenReturn(
            listOf(
                Vegetable("Daikon", "The best one"),
                Vegetable("Carrot", "The most orange")
            )
        )

        BoxPage(repository).handle(request, response)

        verify(response).write(contains("""id="Daikon""""))
        verify(response).write(contains("""id="Carrot""""))
    }

    @Test
    fun `show links`() {
        whenever(repository.all()).thenReturn(listOf(Vegetable("Daikon", "The best one")))

        BoxPage(repository).handle(request, response)

        verify(response).write(contains("""<a href="/Daikon" id="Daikon">Daikon</a>"""))
        verify(response).write(contains("""
    <form action="/Daikon/delete" method="post">
        <button type="submit" id="EatDaikon">eat</button>
    </form>"""
            )
        )
    }

    @Test
    fun `show add button`() {
        whenever(repository.all()).thenReturn(emptyList())

        BoxPage(repository).handle(request, response)

        verify(response).write(contains("""<a href="/add" id="add">"""))
    }
}