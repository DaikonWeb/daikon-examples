import daikon.Request
import daikon.Response
import daikon.RouteAction

class EditAction(private val repository: VegetableRepository) : RouteAction {

    override fun handle(request: Request, response: Response) {
        val vegetable = Vegetable(request.param(":name"), request.param("description"))

        repository.update(vegetable)

        response.redirect("/")
    }
}
