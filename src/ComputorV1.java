public class ComputorV1 {

	private static void displayUsage() {
		System.out.println("Usage: ./computor equation");
	}

	public static void main(String args[]) {
		EquationSolver solver;
		EquationParser parser;
		Equation equation;

		if (args.length != 1) {
			displayUsage();
			return ;
		}
		parser = new EquationParser();
		equation = parser.parse(args[0]);
		solver = new EquationSolver(equation);
		solver.solve();
	}
	
}
