package dev.bksampadi.policy

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class PolicyTest {
    @Test
    fun `policy allows when every rule allows`() {
        val policy =
            Policy(
                listOf(
                    Rule<String> { Decision.Allow },
                    Rule<String> { Decision.Allow },
                ),
            )

        assertEquals(Decision.Allow, policy.evaluate("artifact"))
    }

    @Test
    fun `policy returns the first denial`() {
        val policy =
            Policy(
                listOf(
                    Rule<String> { Decision.Allow },
                    Rule<String> { Decision.Deny("signature required") },
                    Rule<String> { Decision.Deny("approval required") },
                ),
            )

        assertEquals(Decision.Deny("signature required"), policy.evaluate("artifact"))
    }

    @Test
    fun `policy stops evaluating after first denial`() {
        var secondRuleExecuted = false

        val policy =
            Policy(
                listOf(
                    Rule<Int> {
                        Decision.Deny("Rejected")
                    },
                    Rule<Int> {
                        secondRuleExecuted = true
                        Decision.Allow
                    },
                ),
            )

        val result = policy.evaluate(42)

        assertEquals(Decision.Deny("Rejected"), result)
        assertFalse(secondRuleExecuted)
    }
}
