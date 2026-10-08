package dev.bksampadi.policy

fun Decision.message(): String =
    when (this) {
        Decision.Allow -> "allowed"
        is Decision.Deny -> reason
    }
