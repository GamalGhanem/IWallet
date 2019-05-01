
/**
 *
 * @author Bakr
 */
public class Categorize {
    public String name;
    private double upperLimit;
    private double paid;
    
    
    public Categorize (String name, double upperLimit, double paid){
        this.name = name;
        this.upperLimit = upperLimit;
        this.paid = paid;
    }
    
    public double getUpperLimit (){
        return this.upperLimit;
    }
    
    
    public double getPaid (){
        return this.paid;
    }
    
    
    public void updateUpperLimit (double ul) {
        this.upperLimit = ul;
    }
    
    /*
        check if the increasing wil not be bigger than upper limit then update
        it and return true else return false.
    */
    public boolean increasePaid (double amount){
        if ((amount + this.paid) <= upperLimit){
            this.paid += amount;
            return true;
        }
        return false;
    }
}
