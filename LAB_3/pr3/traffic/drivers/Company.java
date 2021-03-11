package pr3.traffic.drivers;
import java.util.Set;
import java.util.TreeSet;
import pr3.traffic.vehicles.Vehicle;

/**
 * Class that defines an Owner
 * @author Kevin de la Coba Malam and Marcos Bernuy
 */
public class Company extends Owner{
    private Person responsible;

    /**
     * Constructor of the Company class
     * @param name Name of the company
     * @param responsible Person who is in charge of the company
     */
    public Company(String name, Person responsible){
        super(name);
        this.responsible = responsible;
        
    }

    public String toString(){
        return "Company:\n" + super.toString() + " (responsible: " +
            this.responsible + ") owner of:\n" + this.getVehicles();
    }

    @Override public Person getRealOwner() {
        return this.responsible;
    }
}

