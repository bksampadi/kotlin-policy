# Kotlin Policy

A small, type-safe policy evaluation library built with Kotlin. Rules are evaluated in order, and the first denial stops evaluation.

## Architecture

```mermaid
flowchart TD
    A["Input value"] --> B["Policy&lt;T&gt;"]
    B --> C["Evaluate next Rule&lt;T&gt;"]
    C --> D{"Decision"}

    D -->|Deny| E["Deny: reason"]
    D -->|Allow| F{"More rules?"}

    F -->|Yes| C
    F -->|No| G["Allow"]

    classDef input fill:#DBEAFE,stroke:#3B82F6,color:#1E3A8A,stroke-width:2px;
    classDef logic fill:#FEF3C7,stroke:#F59E0B,color:#78350F,stroke-width:2px;
    classDef success fill:#DCFCE7,stroke:#22C55E,color:#14532D,stroke-width:2px;
    classDef deny fill:#FEE2E2,stroke:#EF4444,color:#7F1D1D,stroke-width:2px;

    class A input;
    class B,C,D,F logic;
    class G success;
    class E deny;
```

## Design

- **`Decision`** — `Allow` or `Deny(reason)` using a sealed interface.
- **`Rule<T>`** — a type-safe functional interface for individual checks.
- **`Policy<T>`** — evaluates rules in order and stops at the first denial.
- **No framework required** — simple, reusable domain logic.

## Build & Test

Requires **JDK 21**.

```powershell
.\gradlew.bat spotlessCheck test
```

A focused Kotlin learning project exploring sealed types, generics, lambdas, and fail-fast evaluation.