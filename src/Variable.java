public class Variable {

	private int degree;
	private int coefficient;
	
	public Variable(int degree, int coefficient) {
		this.degree = degree;
		this.coefficient = coefficient;
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
}