import java.util.*;

public class Equation {

	private List<Variable> variables;

	public Equation() {
		variables = new ArrayList<Variable>();
	}

	public String toString() {
		StringBuilder res;

		res = new StringBuilder();
		for(Variable v : variables)
				res.append(v.toString());
		if (variables.size() > 0)
			res.append(" = 0");
		res.delete(0, 3);
		return res.toString();
	}

	public List<Variable> getVariables() {
		return variables;
	}

	public double getCoefficientGivenDegree(int degree) {
		for(Variable v : variables)
				if (v.getDegree() == degree)
					return v.getCoefficient();
		return 0;
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
		else
			variables.add(v);
	}

	public int getDegree() {
		int max;

		max = 0;
		for(Variable v : variables) {
				if (max < v.getDegree())
					max = v.getDegree();
		}
		return max;
	}

}
