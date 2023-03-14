enum Direction {
    NORTH, NORTH_EAST, EAST, SOUTH_EAST, SOUTH, SOUTH_WEST, WEST, NORTH_WEST;

    public int getDeltaX() {
        switch (this) {
            case EAST:
            case NORTH_EAST:
            case SOUTH_EAST:
                return 1;
            case WEST:
            case NORTH_WEST:
            case SOUTH_WEST:
                return -1;
            default:
                return 0;
        }
    }

    public int getDeltaY() {
        switch (this) {
            case NORTH:
            case NORTH_EAST:
            case NORTH_WEST:
                return -1;
            case SOUTH:
            case SOUTH_EAST:
            case SOUTH_WEST:
                return 1;
            default:
                return 0;
        }
    }
}
