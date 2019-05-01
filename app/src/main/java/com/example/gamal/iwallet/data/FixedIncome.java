import java.util.Date;

public class FixedIncome extends Income{
	
	private int paidType;  //M -> 1, Y -> 0
	private Date updateDate;
	
	
	
	public FixedIncome(String n, double v) {
		super(n, v, 0);
	}
	public void SetUpdateDate (Date d) {
		this.updateDate = d;
	}
	public Date getUpdateDate() {
		return this.updateDate;
	}
	
	public void SetPaidType(int t) {
		this.paidType = t;
	}
	public int getPaidType() {
		return this.paidType;
	}
	
}
