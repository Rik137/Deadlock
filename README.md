# Java Thread Deadlock Example

This is a simple educational Java project demonstrating **deadlocks** using threads and synchronized methods.  

## Description

The project contains a `Friend` class that models two friends throwing a ball to each other. Each `Friend` has a synchronized method `throwBallTo()` which calls the same method on the other `Friend`.  

When executed with two threads, each thread tries to throw the ball to the other friend **simultaneously**, which can lead to a **deadlock** situation.  

This example is intended to help understand:

- Java threads
- Synchronized methods
- Deadlocks in concurrent programming

## Classes

### Friend

```java
public class Friend implements Comparable<Friend> {

    private final String name;

    public Friend(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public synchronized void throwBallTo(Friend catcher) {
        System.out.format("%s: %s threw the ball to me!%n", catcher.getName(), this.name);
        catcher.throwBallTo(this);
    }

    @Override
    public int compareTo(Friend o) {
        return this.getName().compareTo(o.getName());
    }
}
Fields: name — the name of the friend.
Methods:
throwBallTo(Friend) — synchronized method to simulate throwing a ball.
compareTo(Friend) — compares friends by name (for sorting).
Loader
public class Loader {

    public static void main(String[] args) {
        final Friend vasya = new Friend("Vasya");
        final Friend vitya = new Friend("Vitya");

        new Thread(() -> vasya.throwBallTo(vitya)).start();
        new Thread(() -> vitya.throwBallTo(vasya)).start();
    }
}
Launches two threads that call throwBallTo() on each other.
Demonstrates a classic deadlock scenario.
How to Run
Clone the repository:
git clone <repository-url>
Compile the project:
javac Friend.java Loader.java
Run the program:
java Loader
Observe how the program may freeze due to deadlock.
Key Concepts
Threading: Running multiple tasks simultaneously.
Synchronized methods: Ensure only one thread can execute a method at a time per object.
Deadlock: A situation where two or more threads are blocked forever, each waiting for the other to release a lock.
