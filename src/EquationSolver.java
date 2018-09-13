public class EquationSolver implements IEquationSolver {

	public void solve(Equation equation) {
		int degree = equation.getDegree();
		System.out.println(equation);
		System.out.println("Polynomial degree: " + degree);
		if (degree > 2)
			System.out.println("The polynomial degree is strictly greater than 2, I can't solve");
		else if (degree == 2)
			solveTwoDegree(equation);
		else if (degree == 1)
			solveOneDegree(equation);
		else {
			solveZeroDegree(equation);
		}
	}

	private void solveZeroDegree(Equation equation) {

	}

	private void solveOneDegree(Equation equation) {
		double a = equation.getCoefficientGivenDegree(1);
		double b = equation.getCoefficientGivenDegree(0);
		if ()
		double x1 = -b / a;
		System.out.println("The solutions is:");
		System.out.println(x1);
	}

	private void solveTwoDegree(Equation equation) {
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
