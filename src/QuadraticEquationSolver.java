/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   QuadraticEquationSolver.java                       :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ffloris <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/11/07 10:31:09 by ffloris           #+#    #+#             */
/*   Updated: 2018/11/07 10:31:10 by ffloris          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

public class QuadraticEquationSolver implements IEquationSolver {

	public void solve(Equation equation) {
		double a, b, c, det;

		a = equation.getCoefficientOf(2);
		b = equation.getCoefficientOf(1);
		c = equation.getCoefficientOf(0);
		det = b * b - 4 * a * c;
		det += 0.0; // avoid -0.0
		System.out.println("Discriminant: " + det);
		if (det == 0)
			solveZeroDet(det, a, b);
		else if (det > 0)
			solvePositiveDet(det, a, b);
		else
			solveNegativeDet(det, a, b);
	}

	private void solveZeroDet(double det, double a, double b) {
		double x;

		x = (-b + Utility.sqrt(det)) / (2 * a);
		x += 0.0; // avoid -0.0
		System.out.println("The solution is: " + x);
	}

	private void solvePositiveDet(double det, double a, double b) {
		double x1, x2;

		x1 = (-b - Utility.sqrt(det)) / (2 * a);
		x1 += 0.0; // avoid -0.0
		x2 = (-b + Utility.sqrt(det)) / (2 * a);
		x2 += 0.0; // avoid -0.0
		System.out.println("The two solutions are:");
		System.out.println(x1);
		System.out.println(x2);
	}

	private void solveNegativeDet(double det, double a, double b) {
		double x, immaginary;

		det *= -1;
		x = (-b / (2 * a)) + 0.0;
		immaginary = (Utility.sqrt(det) / (2 * a)) + 0.0;
		System.out.println("The two solutions are:");
		System.out.println(x + " - " + immaginary + "i");
		System.out.println(x + " + " + immaginary + "i");
	}

}
