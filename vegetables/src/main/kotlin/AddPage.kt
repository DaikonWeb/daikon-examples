import daikon.Request
import daikon.Response
import daikon.RouteAction

class AddPage : RouteAction{

    override fun handle(request: Request, response: Response) {
        response.write(Html("Put in the box", """
            <form method="post" action="/add">
                <input type="text" id="name" name="name">Name</input><br/>
                <input type="text" id="description" name="description">Description</input><br/>
                <button type="submit" id="save">Add to box</button>
            </form>
        """).text())
    }
}
