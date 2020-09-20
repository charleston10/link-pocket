package com.core

interface IMapper<E, T> {
    fun transform(data: E): T
    fun transform(data: List<E>): List<T> = data.map { transform(it) }
}