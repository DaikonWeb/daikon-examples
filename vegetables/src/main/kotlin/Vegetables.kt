import daikon.HttpServer

class Vegetables {

    private val httpServer = HttpServer()

    fun start() {
        val repository = InMemoryVegetableRepository()
        httpServer
            .get("/", BoxPage(repository))
            .get("/add", AddPage())
            .post("/add", AddAction(repository))
            .get("/:name", DetailsPage(repository))
            .post("/:name/delete", DeleteAction(repository))
            .get("/:name/edit", EditPage(repository))
            .post("/:name/edit", EditAction(repository))
            .start()
    }

    fun stop() {
        httpServer.close()
    }
}
