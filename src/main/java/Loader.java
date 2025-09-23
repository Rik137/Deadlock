public class Loader {

    public static void main(String[] args) {
        final Friend vasya = new Friend("Rick");
        final Friend vitya = new Friend("Marina");

        new Thread(() -> vasya.throwBallTo(vitya)).start();
        new Thread(() -> vitya.throwBallTo(vasya)).start();
    }
}
