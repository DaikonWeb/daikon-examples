import daikon.core.Context
import daikon.core.Request
import daikon.core.Response
import daikon.core.RouteAction
import daikon.freemarker.html

class AddPage : RouteAction{

    override fun handle(request: Request, response: Response, context: Context) {
        response.html("add", hashMapOf("title" to "Put in the box"))
    }
}
