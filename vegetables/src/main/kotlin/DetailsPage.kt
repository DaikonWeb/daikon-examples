import daikon.Request
import daikon.Response
import daikon.RouteAction

class DetailsPage(private val repository: VegetableRepository) : RouteAction {

    override fun handle(request: Request, response: Response) {
        val vegetable = repository.get(request.param(":name"))

        response.html("details", hashMapOf(
            "vegetable" to vegetable,
            "title" to "Details of ${vegetable.name}"
        ))
    }
}
