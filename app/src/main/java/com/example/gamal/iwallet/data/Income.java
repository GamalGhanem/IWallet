
public class Income {
	
	private double 	value;
	private String name;
	
	
	public Income(String n, double v) {
		this.name = n;
		this.value = v;
	}
	
	public double getValue() {
		return this.value;
	}
	
	public void getValue(double v) {
		this.value = v;
	}
	

}
