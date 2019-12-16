import daikon.Request
import daikon.Response
import daikon.RouteAction

class DetailsPage(private val repository: VegetableRepository) : RouteAction {

    override fun handle(request: Request, response: Response) {
        val vegetable = repository.get(request.param(":name"))

        response.write("""
<html>
    <body>
        <h1>${vegetable.name}</h1>
        <div>
            <div>${vegetable.name}</div>
            <div>${vegetable.description}</div>
        </div>    
    </body>
</html>
""")
    }
}
