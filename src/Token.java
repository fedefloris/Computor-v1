/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Token.java                                         :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ffloris <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/11/07 10:31:09 by ffloris           #+#    #+#             */
/*   Updated: 2018/11/07 10:31:10 by ffloris          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

public class Token {

	private TokenType type;
	private String value;

	public Token(String value, TokenType type) {
		this.value = value;
		this.type = type;
	}

	public TokenType getType() {
		return (type);
	}

	public String getValue() {
		return (value);
	}

}
