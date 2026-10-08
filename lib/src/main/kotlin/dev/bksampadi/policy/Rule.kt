package dev.bksampadi.policy

fun interface Rule<in T> {
    fun evaluate(value: T): Decision
}
