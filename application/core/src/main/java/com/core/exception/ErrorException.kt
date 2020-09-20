package com.core.exception

sealed class ErrorException : Throwable() {
    object BadException : ErrorException()
}