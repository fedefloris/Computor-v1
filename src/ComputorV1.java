public class ComputorV1 {

	public static void main(String args[]) {
		if (args.length != 1) {
			displayUsage();
			return ;
		}
		try {
			solve(parse(args[0]));
		}
		catch (ParserException e) {
      System.out.println(e.getMessage());
    }
	}

	private static void displayUsage() {
		System.out.println("Usage: ./computor equation");
	}

	private static Equation parse(String input) {
		EquationParser parser;

		parser = new EquationParser();
		return (parser.parse(input));
	}

	private static void solve(Equation equation) {
		IEquationSolver solver;

		solver = new EquationSolver();
		solver.solve(equation);
	}

}
