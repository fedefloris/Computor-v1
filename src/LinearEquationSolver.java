public class LinearEquationSolver implements IEquationSolver {

	public void solve(Equation equation) {
		double a, b;

		a = equation.getCoefficientGivenDegree(1);
		b = equation.getCoefficientGivenDegree(0);
		if (a == 0) {
			if (b == 0)
				System.out.println("Every value for x is a solution");
			else
				System.out.println("There is no solution because the equation is inconsistent");
		}
		else {
			double x1 = -b / a;
			System.out.println("The solutions is:");
			System.out.println(x1);
		}
	}

}
