import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Class that defines a sort set and a sum of this sort. It can be divided into odd and even numbers
 * @author Marcos Bernuy, Kevin de la Coba 
 */
public class SortAndSum {
    // We use a Sort object for the data
    private SortedSet<Integer> data = new TreeSet<>();

    /**
     * Constructor of the Class Sort and sum
     * @param args Arguments containing the numbers
     */
    public SortAndSum(String ... args){
        // Parsing the arguments
        for (String s: args){ 		
            int n = Integer.parseInt(s); 	
            this.data.add(n); 		
        }
    }

    /**
     * Method that gets the Even numbers of the sort
     * @return Set with the even numbers
     */
    private SortedSet<Integer> getEven() {
        if (this.data.size() == 0) return null;
        
        // Creating a tree set where the even numbers will go
        SortedSet<Integer> even = new TreeSet<>();
        for(int i: this.data) {
            if (i%2 == 0) {
                even.add(i);
            }
        }
        return even;
    }

    /**
     * Method that adds a number into the 
     * @param number Number to be added in the set
     */
    public void add(Integer number) {
        this.data.add(number);
        return;
    }

    /**
     * Method that gets the odd numbers of the sort
     * @return Set with the odd numbers
     */
    public SortedSet<Integer> getOdd(){
        if (this.data.size() == 0) return null;
        
        // Creating a tree set where the odd numbers will go
        SortedSet<Integer> odd = new TreeSet<>();
        for(int a: this.data) { 
            if (a%2!=0){
                odd.add(a);
            }
        }
        return odd;
    }

    /**
     * Function to get the sum of the odd numbers
     * @return Integer with the odd summation 
     */
    public int getOddSum(){
        int sumOdd = 0;
        for (int a: this.getOdd()){
           sumOdd += a; 
        }
        return sumOdd;
    }

    /**
     * Function to get the sum of the even numbers
     * @return Integer with the even summation 
     */
    public int getEvenSum(){
        int sumEven = 0;
        for (int a: this.getEven()){
           sumEven += a; 
        }
        return sumEven;
    }
    
    /**
     * SortandSum string by default
     */
    @Override public String toString() {
        return "Even numbers " + this.getEven() + " (sum: " + this.getEvenSum() + 
            ")\nOdd numbers " + this.getOdd() + " (sum: " + this.getOddSum() + ")";
    }

    public static void main(String... args) {
        if (args.length<2) {
            System.out.println("At least two numbers are expected");
            System.out.println("Returns the ordered even and odd numbers without repetition and their sum");
        }
        else {
            SortAndSum c = new SortAndSum(args);
            System.out.println(c); // We print the sorted sets and their sum, through the console
            c.add(30); // method to add a number
            c.add(33); // Add number 33
            System.out.println(c); // We print the sorted sets and their sum
            System.out.println("Sum even numbers: "+c.getEvenSum()); // We print the sum even numbers
            System.out.println("Sum odd numbers: "+c.getOddSum()); // We print the sum odd numbers
            System.out.println("Total sum: "+(c.getEvenSum()+c.getOddSum())); // total sum
        }
    }
}
