package dev.bksampadi.policy

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

class DecisionTest {
    @Test
    fun `deny carries its reason`() {
        val decision: Decision = Decision.Deny("artifact is unsigned")

        val denied = assertIs<Decision.Deny>(decision)

        assertEquals("artifact is unsigned", denied.reason)
    }
}
