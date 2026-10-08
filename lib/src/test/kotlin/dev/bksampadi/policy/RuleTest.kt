package dev.bksampadi.policy

import kotlin.test.Test
import kotlin.test.assertEquals

class RuleTest {
    @Test
    fun `rule evaluates a value`() {
        val nonEmpty =
            Rule<String> { value ->
                if (value.isNotEmpty()) {
                    Decision.Allow
                } else {
                    Decision.Deny("value must not be empty")
                }
            }

        assertEquals(Decision.Allow, nonEmpty.evaluate("Kotlin"))
        assertEquals(
            Decision.Deny("value must not be empty"),
            nonEmpty.evaluate(""),
        )
    }
}
