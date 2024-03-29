
package pr3.traffic.drivers;
import pr3.traffic.vehicles.Vehicle;

import java.util.ArrayList;

/**
 * Class that defines an Owner of vehicles
 * @author Kevin de la Coba Malam and Marcos Aarón Bernuy
 */
public abstract class Owner {
    
    private String name;
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    
    /**
     * Constructor of the Owner class
     * @param name Name of the owner
     */
    public Owner(String name) { this.name = name; }

    /**
     * Method to get the name of an Owner
     * @return Name of the owner
     */
    public String getName() { return this.name; }

    /**
     * Method to get the vehicles of the owner
     * @return Vehicles of the owner
     */
    public ArrayList<Vehicle> getVehicles() { return vehicles; }

    /**
     * Method to get the vehicle deatils of the person
     * @return Vehicle details
     */
    public String getVehiclesDetails() {
        // string to save the details
        String details = new String();

        // Getting the details of each vehicle
        for (Vehicle v: this.getVehicles())
            details += "\n"+v.toString();
    
        return details;
    }

    @Override public String toString(){
        return this.name+(this.vehicles.size() != 0 ? " owner of:"+this.getVehiclesDetails() : "");
    }

    /**
     * Method to get the person who owns.
     * @return Person who owns
     */
    public abstract Person getRealOwner();


    /**
     * Method to add a vehicle to the person
     * @param v Vehicle to be added
     */
    public void addVehicle(Vehicle v) { this.vehicles.add(v); }
}
