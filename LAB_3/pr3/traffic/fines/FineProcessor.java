package pr3.traffic.fines;

import pr3.traffic.vehicles.Vehicle;
import pr3.traffic.drivers.Person;
import java.util.*;


/**
 * Class that defines the processing of the fines
 * @author Kevin de la Coba y Marcos Bernuy
 */
public class FineProcessor{
    List<Vehicle> vehicles = new ArrayList<>();

    /**
     * Constructor of the FineProcessor class
     * @param vehicles
     */
    public FineProcessor(List<Vehicle> vehicles){
        this.vehicles = vehicles;
    }

    public void process(List<Fine> fines){
        // Iterating through the fines
        for (Fine f : fines){
            // Looking for the vehicle in the fine
            for(Vehicle v : vehicles) {
                // Checking the vehicle
                if (f.getLicensePlate().equals(v.getLicensePlate())) {
                    Person penalized = v.getDriver();
                    String str = new String();

                    // Getting the person to penalize
                    if (penalized == null) penalized = v.getOwner().getRealOwner();
                    
                    if(penalized.getLicense().getSuspended()){
                        str = "Driver "+penalized.getName()+" is suspended and DGT will take legal action";
                        continue;
                    }

                    //Penalizing the person
                    penalized.getLicense().removePoints(f.getPoints()); 

                    str = "Driver "+penalized.getName()+" loses "+f.getPoints()+" points";
                    
                    if(penalized.getLicense().getSuspended()){
                        str += "\nLicense suspended for driver "+penalized.getName();
                    } else if (penalized.getLicense().getPoints() == 0){
                        str += "\nDriver "+penalized.getName()+" remains with 0 points";
                    }
                    System.out.println(str);
                }
            }
        }
    }
}