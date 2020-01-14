import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import daikon.Request
import daikon.Response
import org.junit.jupiter.api.Test

class AddActionTest {

    private val request: Request = mock()
    private val response: Response = mock()
    private val repository: VegetableRepository = mock()

    @Test
    fun `redirect to box`() {
        whenever(request.param("name")).thenReturn("Garlic")
        whenever(request.param("description")).thenReturn("Useful against vampires")

        AddAction(repository).handle(request, response, mock())

        verify(response).redirect("/")
    }

    @Test
    fun `save the vegetable`() {
        whenever(request.param("name")).thenReturn("Garlic")
        whenever(request.param("description")).thenReturn("Useful against vampires")

        AddAction(repository).handle(request, response, mock())

        verify(repository).add(Vegetable("Garlic", "Useful against vampires"))
    }
}