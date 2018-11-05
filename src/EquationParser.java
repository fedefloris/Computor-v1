import java.util.List;

public class EquationParser {

	public Equation parse(String input) {
		EquationTokenizer tokenizer;
		Equation equation;

		equation = new Equation();
		tokenizer = new EquationTokenizer();
		input = input.replace(" ", "").toLowerCase();
		addTokenPatterns(tokenizer);
		tokenizer.tokenize(input);
    for (Token tok : tokenizer.getTokens())
    	System.out.println("" + tok.type + " " + tok.value);
		parseTokens(equation, tokenizer.getTokens());
		return equation;
	}

	private void addTokenPatterns(EquationTokenizer tokenizer) {
		tokenizer.add("(\\+|-)?[0-9]+(\\.[0-9]+)?\\*?", TokenType.COEFFICIENT);
    tokenizer.add("(\\+|-)?x(\\^[0-9]+)?", TokenType.VARIABLE);
    tokenizer.add("=", TokenType.EQUALS_SIGN);
	}

	private void parseTokens(Equation equation, List<Token> tokens) {
		double coefficient;
		int equalsCount;
		double sign;
		Token token;

		equalsCount = 0;
		coefficient = sign = 1.0;
		for (int i = 0; i < tokens.size(); i++) {
			token = tokens.get(i);
			if (token.type == TokenType.COEFFICIENT) {
				if (!token.value.endsWith("*")) {
					coefficient = Double.parseDouble(token.value);
					equation.add(new Variable(0, coefficient * sign));
					coefficient = 1.0;
				}
				else {
					coefficient = Double.parseDouble(token.value.replace("*", ""));
				}
			}
			else if (token.type == TokenType.VARIABLE) {
				if (token.value.startsWith("-"))
					coefficient = -1.0;
				String value = token.value.replaceAll("^+|-", "");
				int degree = 1;
				if (token.value.startsWith("x^")) {
					String degreeStr = token.value.substring(token.value.indexOf('^') + 1);
					degree = Integer.parseInt(degreeStr);
				}
				equation.add(new Variable(degree, coefficient * sign));
				coefficient = 1.0;
			}
			else if (token.type == TokenType.EQUALS_SIGN) {
				equalsCount++;
				sign *= -1;
				if (equalsCount > 1)
					throw new ParserException("Invalid Syntax: " + token.value);
			}
		}
	}

}
