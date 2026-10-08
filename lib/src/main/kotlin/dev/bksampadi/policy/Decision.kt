package dev.bksampadi.policy

sealed interface Decision {
    data object Allow : Decision

    data class Deny(
        val reason: String,
    ) : Decision
}
