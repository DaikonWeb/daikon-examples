import daikon.Request
import daikon.Response
import daikon.RouteAction

class BoxPage(val repository: VegetableRepository) : RouteAction {

    override fun handle(request: Request, response: Response) {
        val list = repository.all().fold("") { acc, it ->
            acc +
                    """
<div><a href="/${it.name}" id="${it.name}">${it.name}</a></div>
<div>
    <form action="/${it.name}/delete" method="post">
        <button type="submit" id="Eat${it.name}">eat</button>
    </form>
</div>"""
        }

        response.write("""
<html>
    <body>
        <h1>Vegetable box</h1>
        <a href="/add" id="add">Put in the box</a>
        <div>$list</div>    
    </body>
</html>
""")
    }
}
