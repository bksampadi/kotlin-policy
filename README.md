# Kotlin Policy

[![Kotlin CI](https://github.com/bksampadi/kotlin-policy/actions/workflows/ci.yml/badge.svg?branch=main)](https://github.com/bksampadi/kotlin-policy/actions/workflows/ci.yml)

A small, type-safe policy evaluation library built with Kotlin. Rules are evaluated in order, and the first denial stops evaluation.

## Architecture

```mermaid
flowchart TD
    A["Input"] --> B["Policy&lt;T&gt;"]
    B --> C["Evaluate rule"]
    C --> D{"Decision"}
    D -->|Deny| E["Deny(reason)"]
    D -->|Allow| F{"More rules?"}
    F -->|Yes| C
    F -->|No| G["Allow"]

    classDef input fill:#EAF2FF,stroke:#6B8FD6,color:#1E2A3A,stroke-width:1.5px;
    classDef decision fill:#FFF4D6,stroke:#D6A94A,color:#3A2D12,stroke-width:1.5px;
    classDef success fill:#E8F5EC,stroke:#67A97A,color:#193522,stroke-width:1.5px;
    classDef reject fill:#FCECEC,stroke:#D97373,color:#512020,stroke-width:1.5px;

    class A,B,C input;
    class D,F decision;
    class G success;
    class E reject;
```

## Design

- **`Decision`** — `Allow` or `Deny(reason)` using a sealed interface.
- **`Rule<T>`** — a type-safe functional interface for individual checks.
- **`Policy<T>`** — evaluates rules in order and stops at the first denial.
- **No framework required** — simple, reusable domain logic.

## Status

**Working learning library.** Ordered, type-safe rule evaluation with explicit allow/deny decisions and fail-fast behavior. Unit tests cover all-pass, first-denial, and short-circuit execution; GitHub Actions runs formatting checks and tests. No HTTP API or persistence layer.

## Build & test

Requires **JDK 21**. On Windows:

```powershell
.\gradlew.bat spotlessCheck test
```

A focused Kotlin learning project exploring sealed types, generics, lambdas, and fail-fast evaluation.
