import daikon.Request
import daikon.Response
import daikon.RouteAction

class BoxPage(val repository: VegetableRepository) : RouteAction {

    override fun handle(request: Request, response: Response) {
        val list = repository.all().fold("") { acc, it ->
            acc +
                    """
<div class="divTableRow">
    <div class="divTableCell"><a href="/${it.name}" id="${it.name}">${it.name}</a></div>
    <div class="divTableCell">
        <a href="/${it.name}/edit" id="Edit${it.name}">change</a>
        <form action="/${it.name}/delete" method="post" class="action">
            <button type="submit" id="Eat${it.name}">eat</button>
        </form>
    </div>    
</div>"""
        }
        val body = """
            <a href="/add" id="add" class="btn">Put in the box</a>
            <div class="divTable"><div class="divTableBody">$list</div></div>
        """
        response.write(Html("Vegetable box", body).text())
    }
}
