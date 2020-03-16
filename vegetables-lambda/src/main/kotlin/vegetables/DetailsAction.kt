package vegetables

import daikon.core.Context
import daikon.core.Request
import daikon.core.Response
import daikon.core.RouteAction
import daikon.gson.json

class DetailsAction(private val repository: VegetableRepository) : RouteAction {

    override fun handle(request: Request, response: Response, context: Context) {
        val name = request.param(":name")

        try {
            response.json(repository.get(name))
        } catch (t: Throwable) {
            response.status(400)
            response.json(mapOf("error" to "vegetable not found"))
        }
    }
}
