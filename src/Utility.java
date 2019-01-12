/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Utility.java                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ffloris <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/11/07 10:31:09 by ffloris           #+#    #+#             */
/*   Updated: 2018/11/07 10:31:10 by ffloris          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

public class Utility {

	public static double sqrt(double x) {
		double epsilon;
		double guess;

		guess = x;
		epsilon = 1e-15;
		while (Math.abs(guess - x / guess) > epsilon * guess)
			guess = (x / guess + guess) / 2.0;
		return (guess);
	}

}
