import daikon.Context
import daikon.Request
import daikon.Response
import daikon.RouteAction
import daikon.freemarker.html

class DetailsPage(private val repository: VegetableRepository) : RouteAction {

    override fun handle(request: Request, response: Response, context: Context) {
        val vegetable = repository.get(request.param(":name"))

        response.html("details", hashMapOf(
            "vegetable" to vegetable,
            "title" to "Details of ${vegetable.name}"
        ))
    }
}
