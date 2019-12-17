import daikon.Request
import daikon.Response
import daikon.RouteAction

class DetailsPage(private val repository: VegetableRepository) : RouteAction {

    override fun handle(request: Request, response: Response) {
        val vegetable = repository.get(request.param(":name"))

        response.write(Html("Details of ${vegetable.name}", """
<div>
    <div>${vegetable.name}</div>
    <div>${vegetable.description}</div>
</div>
<a href="/" class="btn">Back to the box</a>
        """).text())
    }
}
