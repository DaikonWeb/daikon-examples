import daikon.core.Context
import daikon.core.Request
import daikon.core.Response
import daikon.core.RouteAction

class AddAction(val repository: VegetableRepository) : RouteAction {

    override fun handle(request: Request, response: Response, context: Context) {
        val name = request.param("name")
        val description = request.param("description")
        repository.add(Vegetable(name, description))

        response.redirect("/")
    }
}
