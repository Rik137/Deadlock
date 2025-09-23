public class Friend implements Comparable<Friend> {

    private final String name;

    public Friend(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public synchronized void throwBallTo(Friend catcher) {
        System.out.format("%s: %s threw me a ball!%n", catcher.getName(), this.name);
        catcher.throwBallTo(this);
    }

    @Override
    public int compareTo(Friend o) {
        return this.getName().compareTo(o.getName());
    }
}
