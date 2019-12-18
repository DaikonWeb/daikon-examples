import daikon.Request
import daikon.Response
import daikon.RouteAction

class BoxPage(val repository: VegetableRepository) : RouteAction {

    override fun handle(request: Request, response: Response) {
        response.html("box", hashMapOf(
            "title" to "Vegetable box",
            "vegetables" to repository.all()
        ))
    }
}
