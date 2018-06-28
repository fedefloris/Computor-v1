import java.util.*;

public class Equation {

	private List<Variable> variables;

	public Equation() {
		variables = new ArrayList<Variable>();
	}

	public String toString() {
		StringBuilder res;
		boolean first;
		double abs;
		int temp;

		first = true;
		res = new StringBuilder();
		for(Variable v : variables) {
			if (!first)
				res.append(v.getCoefficient() >= 0 ? " + " : " - ");
			else
				first = false;
			abs = Math.abs(v.getCoefficient());
			temp = (int)abs;
			if (abs == temp)
				res.append(String.valueOf(temp));
			else
				res.append(String.valueOf(abs));
			res.append(" * X^" + v.getDegree());
		}
		if (variables.size() > 0)
			res.append(" = 0");
		return res.toString();
	}

	public List<Variable> getVariables() {
		return variables;
	}

	public void add(Variable v) {
		int index;

		if ((index = variables.indexOf(v)) != -1) {
			variables.get(index).add(v);
			if (variables.get(index).getCoefficient() == 0)
				variables.remove(index);
		}
		else
			variables.add(v);
	}

}
