/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   EquationTokenizer.java                             :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ffloris <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/11/07 10:31:09 by ffloris           #+#    #+#             */
/*   Updated: 2018/11/07 10:31:10 by ffloris          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EquationTokenizer {

	private List<TokenPattern> tokenPatterns;
	private List<Token> tokens;

	public EquationTokenizer() {
		tokens = new ArrayList<Token>();
		tokenPatterns = new ArrayList<TokenPattern>();
	}

	public void add(String regex, TokenType type) {
		TokenPattern pattern;

		pattern = new TokenPattern(Pattern.compile("^("+regex+")"), type);
		tokenPatterns.add(pattern);
	}

	public void tokenize(String input) {
		String value;
		boolean match;

		tokens.clear();
		while (!input.equals("")) {
			match = false;
			for (TokenPattern pattern : tokenPatterns) {
				Matcher m = pattern.getRegex().matcher(input);
				if (m.find()) {
					match = true;
					value = m.group();
					input = input.substring(value.length());
					tokens.add(new Token(value, pattern.getType()));
					break;
				}
			}
			if (!match)
				throw new ParserException("Invalid Syntax: " + input);
		}
	}

	public List<Token> getTokens() {
		return (tokens);
	}

}
