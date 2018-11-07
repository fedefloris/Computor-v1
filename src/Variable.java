/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Variable.java                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ffloris <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/11/07 10:31:09 by ffloris           #+#    #+#             */
/*   Updated: 2018/11/07 10:31:10 by ffloris          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

public class Variable {

	private int degree;
	private double coefficient;

	public Variable() {}

	public Variable(int degree, double coefficient) {
		this.degree = degree;
		this.coefficient = coefficient;
	}

	public boolean equals(Object v) {
		if (v instanceof Variable)
			return ((Variable)v).getDegree() == getDegree();
		return false;
	}

	public String toString() {
		StringBuilder res;
		double abs;
		int temp;

		res = new StringBuilder();
		res.append(getCoefficient() >= 0 ? "+ " : "- ");
		if ((abs = getCoefficient()) < 0)
			abs *= -1;
		temp = (int)abs;
		if (abs == temp)
			res.append(String.valueOf(temp));
		else
			res.append(String.valueOf(abs));
		res.append(" * X^" + getDegree());
		return res.toString();
	}

	public int getDegree() {
		return this.degree;
	}

	public double getCoefficient() {
		return this.coefficient;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	public void add(Variable v) {
		add(v.getCoefficient());
	}

	public void add(double coefficient) {
		this.coefficient += coefficient;
	}

}
