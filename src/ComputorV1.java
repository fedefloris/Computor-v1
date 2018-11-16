/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   ComputorV1.java                                    :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ffloris <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/11/07 10:31:09 by ffloris           #+#    #+#             */
/*   Updated: 2018/11/07 10:31:10 by ffloris          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

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
