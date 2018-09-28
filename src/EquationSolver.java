public class EquationSolver implements IEquationSolver {

	private IEquationSolver quadraticEquationSolver;
	private IEquationSolver linearEquationSolver;

	public EquationSolver() {
		quadraticEquationSolver = new QuadraticEquationSolver();
		linearEquationSolver = new LinearEquationSolver();
	}

	public void solve(Equation equation) {
		int degree;

		degree = equation.getDegree();
		System.out.println("Reduced form: " + equation);
		System.out.println("Degree: " + degree);
		if (degree > 2)
			System.out.println("The degree is strictly greater than 2, I can't solve");
		else if (degree == 2)
			quadraticEquationSolver.solve(equation);
		else
			linearEquationSolver.solve(equation);
	}

}
