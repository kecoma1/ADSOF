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
    private double length;
    private List<Vehicle> participants;
    private boolean allowAttacks = false;
    
    /**
     * Constructor of the object Race
     * @param length length of the Race
     * @param participants List of vehicles of the race
     */
    public Race (double length, List<Vehicle> participants){
        this.length = length;
        this.participants = participants;
    }

    public void allowAttacks(boolean b) {
        this.allowAttacks = true;
    }

    /**
     * Method to simulate a race.
     */
    public void simulate() {
        boolean end = false;
        String str = new String();
        int i = 1;
        
        for(i = 1; !end; i++) {
            System.out.println("--------\n");
            System.out.println("Staring Turn: "+i+"\n");
            System.out.println(this);
            //Attacking phase
            if (i%3 == 0) {
                System.out.println("Starting attack phase.");
                
                
                
            } else 
                System.out.println("Not attacking turn.");

            System.out.println("Ending Turn: "+i+"\n");
            System.out.println("--------\n");
            
            for(Vehicle v: participants) {

                v.setActualPosition(v.getActualPosition()+v.getRealSpeed());
                if (v.getActualPosition()>this.length) {
                    System.out.println(v + "\nhas won the race\n");
                    end = true;
                    break;
                }
            }
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