package pr4.races;

import pr4.vehicles.IVehicle;
import pr4.vehicles.Vehicle;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

/**
 * Class that implements a race.
 * @author Kevin de la Coba and Marcos Bernuy.
 */
public class Race {
    private int length;
    public List<Vehicle> participants;
    
    /**
     * Constructor of the object Race
     * @param length length of the Race
     * @param participants List of vehicles of the race
     */
    public Race (int length, List<Vehicle> participants){
        this.length = length;
        this.participants = participants;
    }

    /**
     * Method to simulate a race.
     */
    public void simulate() {
        boolean end = false;
        String str = new String();
        int i = 1;

        for(i = 1; !end; i++) {
            break;
        }
    }

    @Override public String toString() {
        String str = new String();

        str = "Race with maximum length: "+this.length+"\n";

        for (Vehicle v: this.participants)  {
           str += v.toString();

            // Getting the distance with the vehicles.
           for (Vehicle oponent: this.participants) {
               if (!oponent.equals(v)) {
                    str += "\t"+v.getName()+" distance to "+oponent.getName()+": "+v.getDistanceBetween(oponent)+"\n";
               }
           }
        } 
        return str;
    }
}