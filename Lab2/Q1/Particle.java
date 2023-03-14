class Particle {
    private int x;
    private int y;

    // constructor
    public Particle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // move Particle `direction`
    public void move(Direction direction, int boxWidth, int boxHeight) {
        int newX = x + direction.getDeltaX();
        int newY = y + direction.getDeltaY();

        if (newX < 0 || newX >= boxWidth || newY < 0 || newY >= boxHeight) {
            return;
        }

        x = newX;
        y = newY;
    }
}