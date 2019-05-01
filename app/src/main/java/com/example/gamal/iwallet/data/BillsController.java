import java.util.ArrayList;

public class BillsController {
	private  ArrayList<Bill> allBill = new ArrayList<>();
	private double allPaid = 0;
	
	public ArrayList<Bill> getAllBill(){
        return this.allBill;
    }
    
    public void addBill(Bill b){
        this.allBill.add(b);
        this.allPaid += b.getValue();
    }
    
    /*
    update Bill paid by increase amount 
	*/
	public void updateBillPaid(String name, double amount){
	    for (Bill b : this.allBill){
	        if (b.name.equals(name)){
	            this.allPaid += amount;
	            b.updatevalue(amount);
	        }
	    }
	}
	    
	
}
