package sample

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class QuotePresenter {

    var quoteView: QuoteView? = null

    init {
        ensureNeverFrozen()
    }

    private val mainScope = MainScope(mainUiContext)

    fun requestQuote() {
        mainScope.launch {
            val quote = getQuote()
            quoteView?.showQuote(quote)
        }
    }

    private suspend fun getQuote(): String {
        return ClientApi().getQuote()
    }
}

interface QuoteView {

    fun showQuote(quote: String)
}

internal class MainScope(private val mainContext: CoroutineContext) : CoroutineScope {

    private val job = Job()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        showError(throwable)
    }

    override val coroutineContext: CoroutineContext
        get() = mainContext + job + exceptionHandler

    fun onDestroy() {
        job.cancel()
    }

    private fun showError(t: Throwable) {
        printThrowable(t)
    }
}