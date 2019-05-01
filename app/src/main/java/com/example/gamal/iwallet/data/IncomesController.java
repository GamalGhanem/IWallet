import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class IncomesController {
	private ArrayList<Income> allIncomes = new ArrayList<>();
	private double allValues = 0;
	
	public ArrayList<Income> getAllIncomes(){
        return this.allIncomes;
    }
    
    public void addIncome(Income i){
        this.allIncomes.add(i);
        this.allValues += i.getValue();
    }
    
    /*
    update Income paid by increase amount 
	*/
	public void updateIncomeValue(String name, double amount){
	    for (Income i : this.allIncomes){
	        if (i.name.equals(name)){
	            this.allValues += amount;
	            i.updateValue(amount);
	        }
	    }
	} 
	
	/*
		update Fixed income with this current date.
	 */
    
	public double updateFixedIncome() {
		double allValuesBefore = this.allValues;
		Date currentDate = new Date();
		for (Income i : this.allIncomes) {
			// fixed income then check if need update now or not
			if (i.type == 0) {
				FixedIncome temp = (FixedIncome) i;
				if (checkDates(currentDate, temp.getUpdateDate(), temp.getPaidType())) {
					this.allValues += temp.getValue();
				}
			}
		}
		return this.allValues - allValuesBefore;
	}
	
	private boolean checkDates(Date d1, Date d2, int type) {
		LocalDate localDate1 = d1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate localDate2 = d1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	
		if (type == 1) { // yearly equal
			if((localDate1.getMonthValue() == localDate2.getMonthValue())&& 
					(localDate1.getDayOfMonth() == localDate2.getDayOfMonth())) {
				return true;
			}
			return false;
		}
		else if (type == 0) { // monthly equal
			if(localDate1.getDayOfMonth() == localDate2.getDayOfMonth()) {
				return true;
			}
			return false;
		}
		return false;
	}	
}
