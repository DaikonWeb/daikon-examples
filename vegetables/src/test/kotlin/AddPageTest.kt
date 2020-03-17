import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import daikon.core.Request
import daikon.core.Response
import org.junit.jupiter.api.Test
import org.mockito.Mockito.contains

class AddPageTest {

    private val request: Request = mock()
    private val response: Response = mock()

    @Test
    fun `render page`() {
        AddPage().handle(request, response, mock())

        verify(response).write(contains("""<form method="post" action="/add">"""))
        verify(response).write(contains("""<input type="text" id="name" name="name">Name</input>"""))
        verify(response).write(contains("""<input type="text" id="description" name="description">Description</input>"""))
        verify(response).write(contains("""<button type="submit" id="save""""))
    }
}