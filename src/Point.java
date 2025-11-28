import java.util.*;

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void moveX(double dx) {
        this.x += dx;
    }

    public void moveY(double dy) {
        this.y += dy;
    }

    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    public double distanceTo(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double[] toPolar() {
        double radius = Math.sqrt(x * x + y * y);
        double angle = Math.atan2(y, x);
        return new double[]{radius, angle};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }
}