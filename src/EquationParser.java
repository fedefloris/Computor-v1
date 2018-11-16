/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   EquationParser.java                                :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ffloris <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/11/07 10:31:09 by ffloris           #+#    #+#             */
/*   Updated: 2018/11/07 10:31:10 by ffloris          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

import java.util.List;

public class EquationParser {

	public Equation parse(String input) {
		EquationTokenizer tokenizer;
		Equation equation;

		equation = new Equation();
		tokenizer = new EquationTokenizer();
		input = input.replaceAll("\\s","").toLowerCase();
		addTokenPatterns(tokenizer);
		tokenizer.tokenize(input);
		parseTokens(equation, tokenizer.getTokens());
		return (equation);
	}

	private void addTokenPatterns(EquationTokenizer tokenizer) {
		tokenizer.add("(\\+|-)?[0-9]+(\\.[0-9]+)?\\*?", TokenType.COEFFICIENT);
		tokenizer.add("(\\+|-)?x(\\^?[0-9]+)?", TokenType.VARIABLE);
		tokenizer.add("=", TokenType.EQUALS_SIGN);
	}

	private void parseTokens(Equation equation, List<Token> tokens) {
		double coefficient;
		int equalsCount;
		double sign;

		equalsCount = 0;
		coefficient = sign = 1.0;
		for (Token token : tokens) {
			if (token.getType() == TokenType.COEFFICIENT) {
				if (!token.getValue().endsWith("*")) {
					coefficient *= parseCoefficient(token.getValue());
					equation.add(new Variable(0, coefficient * sign));
					coefficient = 1.0;
				}
				else
					coefficient *= parseCoefficient(token.getValue().replace("*", ""));
			}
			else if (token.getType() == TokenType.VARIABLE) {
				if (token.getValue().startsWith("-"))
					coefficient = -1.0;
				equation.add(new Variable(parseDegree(token.getValue()), coefficient * sign));
				coefficient = 1.0;
			}
			else if (token.getType() == TokenType.EQUALS_SIGN) {
				equalsCount++;
				sign *= -1;
				if (equalsCount > 1)
					throw new ParserException("Invalid Syntax: " + token.getValue());
			}
		}
	}

	private double parseCoefficient(String value) {
		double coefficient;

		try {
			coefficient = Double.parseDouble(value);
		}
		catch (Exception e) {
			throw new ParserException("Invalid Syntax: " + value);
		}
		if (!Double.isFinite(coefficient))
			throw new ParserException("Invalid Syntax: " + value);
		return (coefficient);
	}

	private int parseDegree(String value) {
		int powerIndex;
		int degree;

		degree = 1;
		value = value.replaceAll("\\^|-|\\+", "");
		if (value.length() > 1) {
			try {
				degree = Integer.parseInt(value.substring(1));
			}
			catch (Exception e) {
				throw new ParserException("Invalid Syntax: " + value);
			}
		}
		return (degree);
	}

}
