import daikon.HttpServer

class Vegetables {

    private val httpServer = HttpServer()

    fun start() {
      httpServer.start()
    }

    fun stop() {
        httpServer.close()
    }
}
