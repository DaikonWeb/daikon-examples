import daikon.core.Context
import daikon.core.Request
import daikon.core.Response
import daikon.core.RouteAction
import daikon.freemarker.html

class BoxPage(val repository: VegetableRepository) : RouteAction {

    override fun handle(request: Request, response: Response, context: Context) {
        response.html("box", hashMapOf(
            "title" to "Vegetable box",
            "vegetables" to repository.all()
        ))
    }
}
