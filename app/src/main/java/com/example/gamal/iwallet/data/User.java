
/**
 *
 * @author Bakr
 */
public class User {
    private String name;
    private String email;
    private String password;
    private double budget;
    private CategorizeHub userCategorizeHub;
    private IncomesController userIncomesController;
    private BillsController userBillsController;
    
   
    /*
        this is the sing up function to enter the new user data
    */
    public void signUp(String name, String email, String password, double budget) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.budget = budget;
        this.userCategorizeHub = new CategorizeHub();
        this.userIncomesController = new IncomesController();
        this.userBillsController = new BillsController();
    }
    
    /*
        this function return the current user's  budget.
    */
    public double getBudget (){
        return this.budget;
    }
    /*
        this function update the current user's budget.
    */
    public void updateBudget(double b) {
        this.budget = b;
    }
    
    /*
        login with the email and password.
    */
    public  boolean logIn(String email, String pass){
        return (this.email.equals(email) && this.password.equals(pass));
    }
    /*
    update Categorize paid by increase amount if not release the limit 
    else return false.
    */
    public boolean updateCatergorizePaid(String name, double amount){
    	 if (this.userCategorizeHub.updateCatergorizePaid(name, amount)) {
    		this.budget -= amount;
    		return true;
    	 }
    	 return false;
    	
    }
    
    /*
    update Bill paid by increase amount i
    */
    public void updateBillPaid(String name, double amount){
    	 this.userBillsController.updateBillPaid(name, amount);
    	 this.budget -= amount;
    	
    }
    
    
    public void addBill(Bill b){
    	this.userBillsController.addBill(b);
        this.budget -= b.getValue();
    }
 
}
