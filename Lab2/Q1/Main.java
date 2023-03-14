public class Main {

    public static void main(String[] args) {
        Box box = Box.getInstance(5, 5);
        System.out.println("Initial state:");
        box.displayBox();

        for (int i = 0; i < 5; i++) {
            System.out.println("After moving particles " + (i + 1) + " times:");
            box.moveParticles();
            box.displayBox();
        }

        System.out.println("Final state:");
        box.displayBox();
    }
}