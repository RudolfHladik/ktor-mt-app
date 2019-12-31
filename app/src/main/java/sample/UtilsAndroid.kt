package sample

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

actual val mainUiContext: CoroutineContext = Dispatchers.Main

actual val workerDispatcher: CoroutineDispatcher = Dispatchers.Default

actual fun Any.ensureNeverFrozen() = Unit

actual fun printThrowable(t: Throwable) {
    t.printStackTrace()
}