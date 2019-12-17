import daikon.Request
import daikon.Response
import daikon.RouteAction

class EditPage(private val repository: VegetableRepository) : RouteAction{

    override fun handle(request: Request, response: Response) {
        val vegetable = repository.get(request.param(":name"))
        response.write(Html("Edit ${vegetable.name}", """
<form method="post" action="/${vegetable.name}/edit">
    <input type="text" id="description" name="description" value="${vegetable.description}">Description</input><br/>
    <button type="submit" id="save" class="btn">Change</button>
</form>
        """).text())
    }
}
