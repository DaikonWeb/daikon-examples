package vegetables

import daikon.lambda.HttpHandler
import daikon.lambda.LambdaCall

class VegetablesHandler(
    private val repository: VegetableRepository = FakeVegetableRepository()
) : HttpHandler() {
    override fun LambdaCall.routing() {
        get("/", ListAction(repository))
        get("/:name", DetailsAction(repository))
    }
}