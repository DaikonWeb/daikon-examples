import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import daikon.Request
import daikon.Response
import org.junit.jupiter.api.Test
import org.mockito.Mockito.contains

class AddPageTest {

    private val request: Request = mock()
    private val response: Response = mock()

    @Test
    fun `render page`() {
        AddPage().handle(request, response)

        verify(response).write(contains("""<form method="post" action="/add">"""))
        verify(response).write(contains("""<input type="text" id="name" name="name">Name</input>"""))
        verify(response).write(contains("""<input type="text" id="description" name="description">Description</input>"""))
        verify(response).write(contains("""<button type="submit" id="save""""))
    }
}