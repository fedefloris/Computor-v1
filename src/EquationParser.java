public class EquationParser {

	private Equation equation;

	public EquationParser() {
		equation = new Equation();
	}

	public Equation parse(String input) {
		parseVariables(input.split(" "));
		return equation;
	}

	private void parseVariables(String tokens[]) {
		equation.add(new Variable(1, 2));
	}

}
