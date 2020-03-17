import daikon.core.Context
import daikon.core.Request
import daikon.core.Response
import daikon.core.RouteAction
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
