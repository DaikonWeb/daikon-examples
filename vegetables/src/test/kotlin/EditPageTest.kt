import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import daikon.core.Request
import daikon.core.Response
import org.junit.jupiter.api.Test
import org.mockito.Mockito.contains

class EditPageTest {

    private val request: Request = mock()
    private val response: Response = mock()
    private val repository: VegetableRepository = mock()

    @Test
    fun `render page`() {
        whenever(request.param(":name")).thenReturn("Carrot")
        whenever(repository.get("Carrot")).thenReturn(Vegetable("Carrot", "mmm"))

        EditPage(repository).handle(request, response, mock())

        verify(response).write(contains("""<form method="post" action="/Carrot/edit">"""))
        verify(response).write(contains("""<input type="text" id="description" name="description" value="mmm">Description</input>"""))
        verify(response).write(contains("""<button type="submit" id="save""""))
    }
}