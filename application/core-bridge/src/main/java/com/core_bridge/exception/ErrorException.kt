package com.core_bridge.exception

sealed class ErrorException : Throwable() {
    object BadException : ErrorException()
}