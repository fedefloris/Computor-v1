public class Variable {

	private int degree;
	private int coefficient;
	
	public Variable(int degree, int coefficient) {
		this.degree = degree;
		this.coefficient = coefficient;
	}

	public boolean equals(Object v) {
		if (v instanceof Variable)
			return ((Variable)v).getDegree() == getDegree();
		return false;
	}

	public int getDegree() {
		return this.degree;
	}

	public int getCoefficient() {
		return this.coefficient;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}

	public void add(Variable v) {
		add(v.getCoefficient());
	}

	public void add(int coefficient) {
		this.coefficient += coefficient;
	}

}
