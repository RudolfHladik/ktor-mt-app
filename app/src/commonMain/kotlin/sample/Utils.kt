package sample

import kotlinx.coroutines.CoroutineDispatcher
import kotlin.coroutines.CoroutineContext
import kotlin.native.concurrent.SharedImmutable

@SharedImmutable
expect val mainUiContext: CoroutineContext

@SharedImmutable
expect val workerDispatcher: CoroutineDispatcher

expect fun Any.ensureNeverFrozen()

expect fun printThrowable(t:Throwable)