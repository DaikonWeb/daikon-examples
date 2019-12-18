import daikon.Request
import daikon.Response
import daikon.RouteAction

class EditPage(private val repository: VegetableRepository) : RouteAction{

    override fun handle(request: Request, response: Response) {
        val vegetable = repository.get(request.param(":name"))
        response.html("edit", hashMapOf(
            "title" to "Edit ${vegetable.name}",
            "vegetable" to vegetable
        ))
    }
}
