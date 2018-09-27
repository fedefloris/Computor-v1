public class EquationParser {

	public Equation parse(String input) {
		Equation equation;

		equation = new Equation();
		input = input.replace(" ", "").toLowerCase();
		parseVariables(equation, input);
		return equation;
	}

	private void parseVariables(Equation equation, String input) {
		double sign = 1.0;
		int end;
		for (int i = 0; i < input.length() - 1;) {
			end = i + 1;
			while (end < input.length() && input.charAt(end) != '*')
				end++;
			float f = Float.parseFloat(input.substring(i, end));
			f *= sign;
			i = end + 3;
			end = i + 1;
			while (end < input.length() &&
				input.charAt(end) != '+' &&
				input.charAt(end) != '-' &&
				input.charAt(end) != '=')
				end++;
			int degree = Integer.parseInt(input.substring(i, end));
			equation.add(new Variable(degree, f));
			if (end < input.length() && input.charAt(end) == '=') {
				sign *= -1.0;
				end++;
			}
			i = end;
		}
	}

}
