import java.util.Date;

public class Bill {
	public String name;
	private Date paidDate;
	private double value;
	
	public  Bill(String n, Date d, double v) {
		this.name = n;
		this.paidDate = d;
		this.value = v;
	}
	
	public double getValue() {
		return this.value;
	}
	
	public void updatevalue(double v) {
		this.value = v;	
	}

}
