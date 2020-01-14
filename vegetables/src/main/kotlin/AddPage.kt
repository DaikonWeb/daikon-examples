import daikon.Context
import daikon.Request
import daikon.Response
import daikon.RouteAction
import daikon.freemarker.html

class AddPage : RouteAction{

    override fun handle(request: Request, response: Response, context: Context) {
        response.html("add", hashMapOf("title" to "Put in the box"))
    }
}
