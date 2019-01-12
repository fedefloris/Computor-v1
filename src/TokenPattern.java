/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   TokenPattern.java                                  :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ffloris <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/11/07 10:31:09 by ffloris           #+#    #+#             */
/*   Updated: 2018/11/07 10:31:10 by ffloris          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

import java.util.regex.Pattern;

public class TokenPattern {

	private Pattern regex;
	private TokenType type;

	public TokenPattern(Pattern regex, TokenType type) {
		this.regex = regex;
		this.type = type;
	}

	public Pattern getRegex() {
		return (regex);
	}

	public TokenType getType() {
		return (type);
	}

}
