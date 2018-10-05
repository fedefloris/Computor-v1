public class QuadraticEquationSolver implements IEquationSolver {

	public void solve(Equation equation) {
		double a, b, c, det;

		a = equation.getCoefficientOf(2);
		b = equation.getCoefficientOf(1);
		c = equation.getCoefficientOf(0);
		det = b * b - 4 * a * c;
		System.out.println("Discriminant: " + det);
		if (det == 0)
			solveZeroDet(det, a, b);
		else
			solveNonZeroDet(det, a, b);
	}

	private void solveZeroDet(double det, double a, double b) {
		System.out.println("The solutions is:");
		System.out.println((-b * Math.sqrt(det)) / (2 * a));
	}

	private void solveNonZeroDet(double det, double a, double b) {
		String immaginary;

		immaginary = "";
		if (det < 0) {
			det *= -1;
			immaginary = "i";
		}
		System.out.println("The two solutions are: ");
		System.out.println((-b + -Math.sqrt(det)) / (2 * a) + immaginary);
		System.out.println((-b + Math.sqrt(det)) / (2 * a) + immaginary);
	}

}
