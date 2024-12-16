public class QuadraticCalc {
    // Method to solve the quadratic equation
    public void solveEquation(double a, double b, double c) {
        System.out.println("A is " + a);
        System.out.println("B is " + b);
        System.out.println("C is " + c);

        double discriminant = b * b - 4 * a * c;
        System.out.println("B squared is " + (b * b));
        System.out.println("-4 multiplied by A and C is " + (-4 * a * c));
        System.out.println("2 multiplied by A is " + (2 * a));
        System.out.println("");

        if (discriminant >= 0) {
            double sqrtDiscriminant = Math.sqrt(discriminant);
            double x1 = (-b + sqrtDiscriminant) / (2 * a);
            double x2 = (-b - sqrtDiscriminant) / (2 * a);

            System.out.println("Roots are:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else {
            System.out.println("No real solutions (discriminant is negative).");
        }
    }
}
