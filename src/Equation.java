import java.util.*;

public class Equation {

	private List<Variable> variables;

	public Equation() {
		variables = new ArrayList<Variable>();
	}

	public List<Variable> getVariables() {
		return variables;
	}

	public void add(Variable v) {
		int index;

		if ((index = variables.indexOf(v)) != -1)
			variables.get(index).add(v);
		else
			variables.add(v);
	}

	// reduce equation

}
