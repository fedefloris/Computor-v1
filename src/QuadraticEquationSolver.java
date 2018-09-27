public class QuadraticEquationSolver implements IEquationSolver {

	public void solve(Equation equation) {
		double a, b, c, determinant;

		a = equation.getCoefficientGivenDegree(2);
		b = equation.getCoefficientGivenDegree(1);
		c = equation.getCoefficientGivenDegree(0);
		determinant = b * b - 4 * a * c;
		System.out.print("Discriminant is " + determinant + ", ");
		if (determinant > 0) {
			System.out.println("the two solutions are: ");
			System.out.println((-b + -Math.sqrt(determinant)) / (2 * a));
			System.out.println((-b + Math.sqrt(determinant)) / (2 * a));
		}
		else if (determinant == 0) {
			System.out.println("the solutions is:");
			System.out.println((-b * Math.sqrt(determinant)) / (2 * a));
		}
		else
			System.out.println("no solutions.");
	}

}
