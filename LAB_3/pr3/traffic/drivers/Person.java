package pr3.traffic.drivers;
import java.util.ArrayList;
import pr3.traffic.license.License;

/**
 * Class that defines a person
 * @author Kevin de la Coba Malam and Marcos Aarón Bernuy
 */
public class Person extends Owner {

    private int age;
    private ArrayList<Company> companies = new ArrayList<Company>();
    private License license;

    /**
     * Constructor of the Person class
     * @param name Name of the person
     * @param age Age of 
     */
    public Person(String name, int age) {
        super(name);
        this.age = age;
    }
    
    /**
     * Method to get the age of a person
     * @return Age of the person
     */
    public int getAge() { return this.age; }

    /**
     * Method to get the companies of a person
     * @return Companies of a person
     */
    public ArrayList<Company> getCompanies() {
        return this.companies;
    }

    /**
     * Method to get the license of the person
     * @return License of the person
     */
    public License getLicense(){
        return this.license;
    }
    
    /**
     * Method to add a company to the person
     * @param c Company to be added
     */
    public void addCompany(Company c) { this.companies.add(c); }
    
    /**
     * Method setter of the License
     * @param l License that will be set
     */
    public boolean setLicense(License l){
        if(this.getAge() < l.getPermitAge() || l.getSuspended())
        return false;
        this.license = l;
        return true;
    }
    
    @Override public String toString() { return super.toString(); }
    @Override public Person getRealOwner() { return this; }
}
