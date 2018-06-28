public class Variable {

	private int degree;
	private double coefficient;
	
	public Variable(int degree, double coefficient) {
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
