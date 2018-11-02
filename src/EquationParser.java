public class EquationParser {

	public Equation parse(String input) {
		Equation equation;

		EquationTokenizer tokenizer = new EquationTokenizer();
		addTokenPatterns(tokenizer);
    try {
			tokenizer.tokenize(input.replace(" ", ""));
      for (Token tok : tokenizer.getTokens())
      	System.out.println("" + tok.id + " " + tok.value);
    }
    catch (ParserException e) {
      System.out.println(e.getMessage());
    }
		equation = new Equation();
		// if (!parseVariables(equation, input))
		// 	return (null);
		return equation;
	}

	private void addTokenPatterns(EquationTokenizer tokenizer) {
		tokenizer.add("\\+|-", 1);
		tokenizer.add("[0-9]+(\\.[0-9]+)?", 2);
    tokenizer.add("\\*|/", 3);
    tokenizer.add("x|X", 4);
		tokenizer.add("\\^", 5);
    tokenizer.add("=", 6	);
	}

	private boolean parseVariables(Equation equation, String input) {
		double sign = 1.0;
		int end;
		for (int i = 0; i < input.length() - 1;) {
			end = i + 1;
			while (end < input.length() && input.charAt(end) != '*')
				end++;
			double f = Double.parseDouble(input.substring(i, end));
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
		return (true);
	}

}
