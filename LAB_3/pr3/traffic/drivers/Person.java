package pr3.traffic.drivers;
import java.util.Set;
import java.util.TreeSet;
import pr3.traffic.vehicles.Vehicle;

/**
 * Class that defines a person
 * @author Kevin de la Coba Malam and Marcos Aarón Bernuy
 */
public class Person extends Owner {

    private int age;

    /**
     * Constructor of the Person class
     * @param name Name of the person
     * @param age Age of 
     */
    public Person(String name, int age) {
        super(name);
        this.age = age;
    }

    @Override public Person getRealOwner() {
        return this;
    }

    /**
     * Method to get the age of a person
     * @return Age of the person
     */
    public int getAge() {
        return this.age;
    }
    
}
