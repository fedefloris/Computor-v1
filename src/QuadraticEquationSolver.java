public class QuadraticEquationSolver implements IEquationSolver {

	public void solve(Equation equation) {
		double a = equation.getCoefficientGivenDegree(2);
		double b = equation.getCoefficientGivenDegree(1);
		double c = equation.getCoefficientGivenDegree(0);
		double determinant = b * b - 4 * a * c;

		System.out.println(determinant);
		if (determinant > 0) {
			System.out.println("Discriminant is strictly positive, the two solutions are: ");
			double x1 = (-b + -Math.sqrt(determinant)) / (2 * a);
			double x2 = (-b + Math.sqrt(determinant)) / (2 * a);
			System.out.println(x1);
			System.out.println(x2);
		}
		else if (determinant == 0) {
			System.out.println("The solutions is:");
			System.out.println((-b * Math.sqrt(determinant)) / (2 * a));
		}
		else {
			System.out.println("No solutions");
		}
	}

}
