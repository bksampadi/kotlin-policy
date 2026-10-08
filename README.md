# kotlin-policy

A small, type-safe policy engine built to explore idiomatic Kotlin.

## Design

A value is evaluated against an ordered set of rules. Policies fail fast on
the first denial.

    value → Rule<T> → Policy<T> → Decision
                                  ├── Allow
                                  └── Deny(reason)

## Kotlin concepts

- Sealed interfaces and exhaustive `when`
- Data classes and data objects
- Generic variance
- Functional interfaces and lambdas
- Extension functions
- Immutable domain modelling

## Build

    .\gradlew.bat test
    .\gradlew.bat spotlessCheck