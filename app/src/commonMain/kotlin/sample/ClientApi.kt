package sample

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.withContext

class ClientApi {

    private val client = HttpClient()

    suspend fun getQuote(): String = withContext(workerDispatcher) {
        client.get<String>("https://ron-swanson-quotes.herokuapp.com/v2/quotes")
    }
}