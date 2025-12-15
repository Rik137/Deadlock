# Java Thread Deadlock Example

Educational Java project demonstrating a **classic deadlock** scenario using threads and `synchronized` methods.

The goal of this repository is not to provide production-ready code, but to clearly show how a deadlock can occur when multiple threads acquire locks in an inconsistent order.

---

## Description

The project models two `Friend` objects throwing a ball to each other.

Each `Friend` has a synchronized method `throwBallTo(Friend)`.
When two threads call this method simultaneously on different objects, a **circular lock dependency** may occur:

* Thread A locks `Friend #1` and waits for `Friend #2`
* Thread B locks `Friend #2` and waits for `Friend #1`

Result: both threads are blocked forever.

This example is intentionally minimal and deterministic enough to reliably demonstrate the problem.

---

## Project Structure

### `Friend`

Represents a participant in the interaction.

**Fields**

* `name` — immutable identifier of the friend

**Methods**

* `throwBallTo(Friend)` — synchronized method that may cause a deadlock
* `compareTo(Friend)` — compares friends by name (not used directly, included for future extensions)

---

### `Loader`

Entry point of the application.

Creates two `Friend` instances and starts two threads that call `throwBallTo()` on each other simultaneously.

---

## How to Run

Compile the sources:

```bash
javac Friend.java Loader.java
```

Run the program:

```bash
java Loader
```

In most runs, the application will freeze due to a deadlock.

---

## Key Concepts Demonstrated

* Java threads
* Intrinsic locks (`synchronized`)
* Circular wait condition
* Deadlocks in concurrent programming

---

## Notes

* The recursive call inside the synchronized method is intentional and used only for demonstration purposes.
* This code **must not** be used as a design reference for real applications.

The repository exists purely as a learning and demonstration artifact.

