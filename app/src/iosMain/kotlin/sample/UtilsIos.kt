package sample

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlin.coroutines.CoroutineContext
import kotlin.native.concurrent.SharedImmutable
import kotlin.native.concurrent.ensureNeverFrozen

@SharedImmutable
actual val mainUiContext: CoroutineContext = Dispatchers.Main

@SharedImmutable
actual val workerDispatcher: CoroutineDispatcher = newSingleThreadContext("mr background")

actual fun Any.ensureNeverFrozen() = ensureNeverFrozen()

actual fun printThrowable(t: Throwable) {
    t.printStackTrace()
}
