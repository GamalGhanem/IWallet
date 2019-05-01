
public class Income {
	
	protected double 	value;
	protected String name;
	protected int type; 		// 0 for fixed income and 1 for variable income
	
	
	public Income(String n, double v, int t) {
		this.name = n;
		this.value = v;
		this.type = t;
	}
	
	public double getValue() {
		return this.value;
	}
	
	public void updateValue(double v) {
		this.value = v;
	}
	

}
