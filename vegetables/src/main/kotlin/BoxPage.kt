import daikon.Context
import daikon.Request
import daikon.Response
import daikon.RouteAction
import daikon.freemarker.html

class BoxPage(val repository: VegetableRepository) : RouteAction {

    override fun handle(request: Request, response: Response, context: Context) {
        response.html("box", hashMapOf(
            "title" to "Vegetable box",
            "vegetables" to repository.all()
        ))
    }
}
