public enum Direction {
    UP (0, -3.5),
    DOWN (0, 3.5),
    RIGHT (3.5, 0),
    LEFT (-3.5, 0);
    double dx;
    double dy;

    Direction(double x, double y) {
        this.dx = x;
        this.dy = y;
    }
}

