import daikon.core.Context
import daikon.core.Request
import daikon.core.Response
import daikon.core.RouteAction
import daikon.freemarker.html

class EditPage(private val repository: VegetableRepository) : RouteAction{

    override fun handle(request: Request, response: Response, context: Context) {
        val vegetable = repository.get(request.param(":name"))
        response.html("edit", hashMapOf(
            "title" to "Edit ${vegetable.name}",
            "vegetable" to vegetable
        ))
    }
}
