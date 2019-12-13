import daikon.HttpServer

class Vegetables {

    private val httpServer = HttpServer()

    fun start() {
        val repository = InMemoryVegetableRepository()
        httpServer
          .get("/", BoxPage(repository))
          .get("/add", AddPage())
          .post("/add", AddAction(repository))
          .start()
    }

    fun stop() {
        httpServer.close()
    }
}
