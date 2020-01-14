import daikon.Context
import daikon.Request
import daikon.Response
import daikon.RouteAction

class DeleteAction(private val repository: VegetableRepository) : RouteAction {

    override fun handle(request: Request, response: Response, context: Context) {
        repository.delete(request.param(":name"))

        response.redirect("/")
    }
}
