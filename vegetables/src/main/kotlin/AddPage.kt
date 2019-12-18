import daikon.Request
import daikon.Response
import daikon.RouteAction

class AddPage : RouteAction{

    override fun handle(request: Request, response: Response) {
        response.html("add", hashMapOf("title" to "Put in the box"))
    }
}
