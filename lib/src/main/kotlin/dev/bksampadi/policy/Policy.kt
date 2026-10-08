package dev.bksampadi.policy

class Policy<T>(
    private val rules: List<Rule<T>>,
) {
    fun evaluate(value: T): Decision {
        for (rule in rules) {
            when (val decision = rule.evaluate(value)) {
                Decision.Allow -> continue
                is Decision.Deny -> return decision
            }
        }

        return Decision.Allow
    }
}
