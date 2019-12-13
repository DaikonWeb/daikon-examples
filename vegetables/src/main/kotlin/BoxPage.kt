import daikon.Request
import daikon.Response
import daikon.RouteAction

class BoxPage(val repository: VegetableRepository) : RouteAction {

    override fun handle(request: Request, response: Response) {
        response.write("""
<html>
    <body>
        <div>""")
        repository.all().forEach {
            response.write("""<div>${it.name}</div>""")
        }
        response.write("""</div>    
    </body>
</html>
""")
    }
}
