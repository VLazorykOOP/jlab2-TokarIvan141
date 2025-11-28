public class SquareEquation {
    private double a;
    private double b;
    private double c;

    public SquareEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getRootCount() {
        if (a == 0) {
            if (b == 0) {
                return (c == 0) ? -1 : 0;
            }
            return 1;
        }

        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            return 0;
        } else if (discriminant == 0) {
            return 1;
        } else {
            return 2;
        }
    }

    public double[] getRoots() {
        if (a == 0) {
            if (b == 0) {
                return (c == 0) ? null : new double[0];
            }
            double root = -c / b;
            return new double[]{root};
        }

        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            return new double[0];
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        } else {
            double sqrtD = Math.sqrt(discriminant);
            double root1 = (-b + sqrtD) / (2 * a);
            double root2 = (-b - sqrtD) / (2 * a);
            return new double[]{root1, root2};
        }
    }

    @Override
    public String toString() {
        if (a == 0) {
            if (b == 0) {
                return c + " = 0";
            }
            return b + "x + " + c + " = 0";
        }

        StringBuilder sb = new StringBuilder();
        if (a != 1) sb.append(a);
        sb.append("x^2");

        if (b != 0) {
            sb.append(b > 0 ? " + " : " - ");
            if (Math.abs(b) != 1) sb.append(Math.abs(b));
            sb.append("x");
        }

        if (c != 0) {
            sb.append(c > 0 ? " + " : " - ");
            sb.append(Math.abs(c));
        }

        sb.append(" = 0");
        return sb.toString();
    }
}