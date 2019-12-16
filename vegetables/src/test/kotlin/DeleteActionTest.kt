import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import daikon.Request
import daikon.Response
import org.junit.jupiter.api.Test

class DeleteActionTest {

    private val request: Request = mock()
    private val response: Response = mock()
    private val repository: VegetableRepository = mock()

    @Test
    fun `remove selected vegetable`() {
        whenever(request.param(":name")).thenReturn("Celery")

        DeleteAction(repository).handle(request, response)

        verify(repository).delete("Celery")
    }

    @Test
    fun `redirect to box`() {
        whenever(request.param("name")).thenReturn("Garlic")

        DeleteAction(repository).handle(request, response)

        verify(response).redirect("/")
    }
}