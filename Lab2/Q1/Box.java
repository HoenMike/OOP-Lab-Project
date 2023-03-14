import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Box {
    private static Box instance = null;

    private int width;
    private int height;
    private List<Particle> particles;

    private Box(int width, int height) {
        final int NUMBER_OF_PARTICLE = 2;
        this.width = width;
        this.height = height;
        particles = new ArrayList<>();
        Random random = new Random();

        // create 3 new Particle
        for (int i = 0; i < NUMBER_OF_PARTICLE; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            particles.add(new Particle(x, y));
        }
    }

    public static Box getInstance(int width, int height) {
        if (instance == null) {
            instance = new Box(width, height);
        }
        return instance;
    }

    public int getParticleCount() {
        return particles.size();
    }

    public void moveParticles() {
        for (int i = 0; i < getParticleCount(); i++) {

            Particle tempParticle = particles.get(i);
            Direction direction = Direction.values()[new Random().nextInt(Direction.values().length)];
            tempParticle.move(direction, width, height);
        }
        handleCollisions();
    }

    private void handleCollisions() {

        List<Particle> newParticles = new ArrayList<>();

        for (int i = 0; i < getParticleCount(); i++) {
            Particle tempParticle1 = particles.get(i);

            for (int j = i + 1; j < getParticleCount(); j++) {
                Particle tempParticle2 = particles.get(j);

                if (tempParticle1.getX() == tempParticle2.getX() && tempParticle1.getY() == tempParticle2.getY()) {
                    int x = new Random().nextInt(width);
                    int y = new Random().nextInt(height);

                    Particle newParticle = new Particle(x, y);
                    newParticles.add(newParticle);
                }
            }
        }
        particles.addAll(newParticles);
    }

    public void displayBox() {
        // loop Height time
        for (int b = 0; b < height; b++) {
            // loop Width time
            for (int a = 0; a < width; a++) {
                // default status
                boolean hasParticle = false;
                // check if there are any Points at (a , b)
                for (Particle particle : particles) {
                    if (particle.getX() == a && particle.getY() == b) {
                        hasParticle = true;
                        break;
                    }
                }
                System.out.print(hasParticle ? "*  " : "-  ");
            }
            System.out.println();
        }
    }
}