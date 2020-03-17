import daikon.core.Context
import daikon.core.Request
import daikon.core.Response
import daikon.core.RouteAction

class EditAction(private val repository: VegetableRepository) : RouteAction {

    override fun handle(request: Request, response: Response, context: Context) {
        val vegetable = Vegetable(request.param(":name"), request.param("description"))

        repository.update(vegetable)

        response.redirect("/")
    }
}
