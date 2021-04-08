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
    public List<IVehicle> participants;
    
    /**
     * Constructor of the object Race
     * @param length length of the Race
     * @param participants List of vehicles of the race
     */
    public Race (int length, List<IVehicle> participants){
        this.length = length;
        this.participants = participants;
    }

    /**
     * Method to simulate a race.
     */
    public void simulate() {
        boolean end = false;
        String str = new String()
        int i = 1;

        for(i = 1; !end; i++) {
            
        }
    }

    /**
     * Method to get the distance between 2 vehicles.
     * @param v Vehicle to check the distance with.
     * @return Distance between the 2 vehicles. 
     */
    public double getDistanceBetween(Vehicle v) {
        return Math.abs(this.getActualPosition() - v.getActualPosition());
    }

    @Overrid public String toString() {}
        String str = new String();

        str = "Race with maximum length: "+this.length+"\n";

        for (Veh)
   v: this.participants  {
           str += v.toString();

            // Getting the distance with the vehicles.
           for (Vehicle oponent: this.participants) {
               if (!oponent.equals(this)) {
                    str += "\t"+this.getName()+" distance to "+oponent.getName()+": "+this.getDistanceBetween(this)+"\n";
               }
           }
        } 
}