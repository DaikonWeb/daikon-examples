import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import daikon.Request
import daikon.Response
import org.junit.jupiter.api.Test
import org.mockito.Mockito.contains

class DetailsPageTest {

    private val request: Request = mock()
    private val response: Response = mock()
    private val repository: VegetableRepository = mock()

    @Test
    fun render() {
        whenever(request.param(":name")).thenReturn("Daikon")
        whenever(repository.get("Daikon")).thenReturn(Vegetable("Daikon", "white"))

        DetailsPage(repository).handle(request, response, mock())

        verify(response).write(contains("Daikon"))
        verify(response).write(contains("white"))
    }
}