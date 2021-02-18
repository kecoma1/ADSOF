public class SortAndSum {
    
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
