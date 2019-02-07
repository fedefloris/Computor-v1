/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Equation.java                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: ffloris <marvin@42.fr>                     +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/11/07 10:31:09 by ffloris           #+#    #+#             */
/*   Updated: 2018/11/07 10:31:10 by ffloris          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

import java.util.List;
import java.util.ArrayList;

public class Equation {

	private List<Variable> variables;

	public Equation() {
		variables = new ArrayList<Variable>();
	}

	public String toString() {
		StringBuilder res;

		if (variables.size() == 0)
			return ("0 = 0");
		res = new StringBuilder();
		for (Variable v : variables) {
			res.append(" ");
			res.append(v.toString());
		}
		res.append(" = 0");
		if (res.charAt(1) == '+')
			res.delete(0, 3);
		else {
			res.delete(0, 3);
			res.insert(0, '-');
		}
		return (res.toString());
	}

	public List<Variable> getVariables() {
		return (variables);
	}

	public double getCoefficientOf(int degree) {
		for (Variable v : variables)
			if (v.getDegree() == degree)
				return (v.getCoefficient());
		return (0);
	}

	public void add(Variable v) {
		int index;

		if (v.getCoefficient() == 0)
			return;
		if ((index = variables.indexOf(v)) != -1) {
			variables.get(index).add(v);
			if (variables.get(index).getCoefficient() == 0)
				variables.remove(index);
		}
		else {
			index = 0;
			while (index < variables.size()) {
				if (variables.get(index).getDegree() < v.getDegree())
					break;
				index++;
			}
			variables.add(index, v);
		}
	}

	public int getDegree() {
		int max;

		max = 0;
		for (Variable v : variables) {
			if (max < v.getDegree())
				max = v.getDegree();
		}
		return (max);
	}

}
