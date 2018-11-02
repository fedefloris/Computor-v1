public class ComputorV1 {

	private static void displayUsage() {
		System.out.println("Usage: ./computor equation");
	}

	public static void main(String args[]) {
		IEquationSolver solver;
		EquationParser parser;
		Equation equation;

		if (args.length != 1) {
			displayUsage();
			return ;
		}
		try {
			parser = new EquationParser();
			equation = parser.parse(args[0]);
			solver = new EquationSolver();
			solver.solve(equation);
		}
		catch (ParserException e) {
      System.out.println(e.getMessage());
    }
	}

}
