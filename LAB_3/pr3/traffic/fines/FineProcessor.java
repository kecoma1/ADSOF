package pr3.traffic.fines;

import pr3.traffic.vehicles.Vehicle;
import pr3.traffic.drivers.Person;
import pr3.traffic.itvs.Itv;
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

    /**
     * Function to write in a file a string
     * @param str String to write in the file
     */
    public void writeFile(String str) {
        BufferedWriter writer = new BufferedWriter(new FileWriter("ITV_expired.txt", true));
        writer.append(str);
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
                    int pointsToRemove = 0;

                    // Checking if the vehicle has passed the required ITV
                    if (v.checkPassedITV() == false) {
                        pointsToRemove += 1;
                        str += "The vehicle "+v+" didn't pass the ITV, the driver "+penalized
                        +" is being penalized with an additional point.\n";
                        this.writeFile(str);
                    }

                    // Getting the person to penalize
                    if (penalized == null) penalized = v.getOwner().getRealOwner();
                    
                    if(penalized.getLicense().getSuspended()){
                        str += "Driver "+penalized.getName()+" is suspended and DGT will take legal action";
                        continue;
                    }

                    //Penalizing the person
                    pointsToRemove += f.getPoints();
                    penalized.getLicense().removePoints(pointsToRemove); 

                    str += "Driver "+penalized.getName()+" loses "+f.getPoints()+" points";
                    
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