/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   CubicEquationSolver.java                           :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ffloris <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/11/07 10:31:09 by ffloris           #+#    #+#             */
/*   Updated: 2018/11/07 10:31:10 by ffloris          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

public class CubicEquationSolver implements IEquationSolver {

	public void solve(Equation equation) {
		double a, b, c, d;
		double f, g, h;

		a = equation.getCoefficientOf(3);
		b = equation.getCoefficientOf(2);
		c = equation.getCoefficientOf(1);
		d = equation.getCoefficientOf(0);
		f = getF(a, b, c);
		g = getG(a, b, c, d);
		h = getH(f, g);
		if (h > 0)
			solveNotRealRoots(a, b, g, h);
		else if (f == 0 && g == 0 && h == 0)
			solveOneRoot(a, d);
		else
			solveRealRoots(a, b, g, h);
	}

	private double getF(double a, double b, double c) {
		double f;

		f = (3 * (c / a) - (b * b) / (a * a)) / 3;
		return (f);
	}

	private double getG(double a, double b, double c, double d) {
		double g;

		g = (2 * b * b * b) / (a * a * a);
		g += (-9 * b * c) / (a * a);
		g += (27 * d) / a;
		g /= 27;
		return (g);
	}

	private double getH(double f, double g) {
		double h;

		h = ((g * g) / 4 + (f * f * f) / 27);
		return (h);
	}

	private void solveOneRoot(double a, double d) {
		double x;

		x = -Math.pow(d / a, 1.0 / 3);
		System.out.println("The solutions is: "+ x);
	}

	private void solveRealRoots(double a, double b, double g, double h) {
		double i, j, k, l, m, n, p;
		double x1, x2, x3;

		i = Math.pow((g * g) / 4 - h, 1.0 / 2);
		j = Math.pow(i, 1.0 / 3);
		k = Math.acos(-g / (2 * i));
		l = -j;
		m = Math.cos(k / 3);
		n = Math.sqrt(3) * Math.sin(k / 3);
		p = -b / (3 * a);
		x1 = 2 * j * Math.cos(k / 3) - b / (3 * a);
		x2 = l * (m + n) + p;
		x3 = l * (m - n) + p;
		System.out.println("The solutions are:");
		System.out.println(x1);
		System.out.println(x2);
		System.out.println(x3);
	}

	private void solveNotRealRoots(double a, double b, double g, double h) {
		double x1, x2, immaginary;
		double r, s, t, u;

		r = -g / 2 + Math.sqrt(h);
		s = Math.pow(r, 1.0 / 3);
		t = -g / 2 - Math.sqrt(h);
		u = -Math.pow(-t, 1.0 / 3);
		x1 = s + u - (b / (3 * a));
		x2 = -((s + u) / 2) - (b / (3 * a));
		immaginary = ((s - u) * Math.sqrt(3)) / 2;
		System.out.println("The solutions are:");
		System.out.println(x1);
		System.out.println(x2 + " + i * " + immaginary);
		System.out.println(x2 + " - i * " + immaginary);
	}

}
