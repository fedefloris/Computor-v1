/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   EquationSolver.java                                :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ffloris <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/11/07 10:31:09 by ffloris           #+#    #+#             */
/*   Updated: 2018/11/07 10:31:10 by ffloris          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

public class EquationSolver implements IEquationSolver {

	private IEquationSolver cubicEquationSolver;
	private IEquationSolver quadraticEquationSolver;
	private IEquationSolver linearEquationSolver;

	public EquationSolver() {
		cubicEquationSolver = new CubicEquationSolver();
		quadraticEquationSolver = new QuadraticEquationSolver();
		linearEquationSolver = new LinearEquationSolver();
	}

	public void solve(Equation equation) {
		int degree;

		degree = equation.getDegree();
		System.out.println("Reduced form: " + equation);
		System.out.println("Degree: " + degree);
		if (degree > 3)
			System.out.println("The degree is strictly greater than 3, I can't solve");
		else if (degree == 3)
			cubicEquationSolver.solve(equation);
		else if (degree == 2)
			quadraticEquationSolver.solve(equation);
		else
			linearEquationSolver.solve(equation);
	}

}
