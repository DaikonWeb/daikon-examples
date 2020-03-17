import daikon.core.Context
import daikon.core.Request
import daikon.core.Response
import daikon.core.RouteAction

class DeleteAction(private val repository: VegetableRepository) : RouteAction {

    override fun handle(request: Request, response: Response, context: Context) {
        repository.delete(request.param(":name"))

        response.redirect("/")
    }
}
