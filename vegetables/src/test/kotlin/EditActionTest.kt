import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import daikon.Request
import daikon.Response
import org.junit.jupiter.api.Test

class EditActionTest {

    private val request: Request = mock()
    private val response: Response = mock()
    private val repository: VegetableRepository = mock()

    @Test
    fun `change selected vegetable`() {
        whenever(request.param(":name")).thenReturn("Celery")
        whenever(request.param("description")).thenReturn("mmm")

        EditAction(repository).handle(request, response, mock())

        verify(repository).update(Vegetable("Celery", "mmm"))
    }

    @Test
    fun `redirect to box`() {
        whenever(request.param(":name")).thenReturn("Garlic")
        whenever(request.param("description")).thenReturn("mmm")

        EditAction(repository).handle(request, response, mock())

        verify(response).redirect("/")
    }
}