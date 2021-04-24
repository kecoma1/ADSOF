package pr4.races;

import pr4.powerups.*;
import pr4.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.text.DecimalFormat;

/**
 * Class that implements a race.
 * @author Kevin de la Coba and Marcos Aarón Bernuy.
 */
public class Race {
    private double length;
    private boolean allowAttacks = false;
    private boolean allowPowerUps = false;
    private List<Vehicle> participants;
    private List<IPowerUp> powerUps = new ArrayList<>();
    private static DecimalFormat df = new DecimalFormat("0.0");

    /**
     * Constructor of the object Race
     * @param length length of the Race
     * @param participants List of vehicles of the race
     */
    public Race (double length, List<Vehicle> participants){
        this.length = length;
        this.participants = participants;

        // Adding power-ups
        this.powerUps.add(new AttackAll());
        this.powerUps.add(new Teleport());
        this.powerUps.add(new Swap());

        // Setting the race in all participants
        for (Vehicle v: participants) 
            v.setRace(this);
    }

    /**
     * Method to get the decimal format used in the race.
     * @return Decimal format used in the race
     */
    public static DecimalFormat getDecimalFormat() {
        return df;
    }

    /**
     * Method to set if a race can have a attacks or not.
     * @param b Boolean value to set it.
     */
    public void allowAttacks(boolean b) {
        this.allowAttacks = b;
    }

    /**
     * Method to set if the race can have power ups or not.
     * @param b Boolean value to set it.
     */
    public void allowPowerUps(boolean b) {
        this.allowPowerUps = b;
    }

    /**
     * Method to get the participants of the race.
     * @return List of the participants of the race.
     */
    public List<Vehicle> getParticipants() {
        return this.participants;
    }

    /**
     * Method to simulate a race.
     */
    public void simulate() {
        boolean end = false;
        int i = 1;
        
        // Iterating over the turns
        for(i = 1; !end; i++) {
            System.out.println("--------\n");
            System.out.println("Staring Turn: "+i+"\n");

            // Showing state of the race
            System.out.println(this);

            //Attacking phase
            if (this.allowAttacks) {
                if (i%3 == 0) { // If we are in a turn multiple of 3
                    System.out.println("Starting attack phase.");
                    
                    // Vehicles attacking
                    for (Vehicle v: this.participants) {

                        // If the vehicle doesn't have a banana dispenser
                        // or its damaged it cannot attack.
                        if (v.canAttack()) {
                            Vehicle attacked = this.getClosestOpponentTo(v);
                            double random = 1 + (int)(Math.random() * ((2 - 1) + 1)); // 50% probability of generating a 1
                            
                            if (attacked == null || random == 1.0 || v.getDistanceBetween(attacked) > 30.0) {
                                System.out.println(v.getName()+" fails attack");
                            } else {
                                v.attack(attacked);
                            }
                        } else {
                            System.out.println(v.getName()+" can not attack");
                        }
                    }
                    System.out.println("Ends attack phase.");
                } else {
                    System.out.println("Not attacking turn.");
                }
            }
            
            if (i > 3 && i%3 != 0) { // Not an attacking phase
                if (this.allowPowerUps) { // Power up phase
                    double random = 1 + (int)(Math.random() * ((10 - 1) + 1));
                    
                    if (random == 1.0) { // 10% posibilities
                        System.out.println("Turn with power ups");
                        
                        for (Vehicle v: this.participants) {
                            random = 1 + (int)(Math.random() * ((3 - 1) + 1));
                            this.powerUps.get((int)(random-1)).applyPowerUp(v);
                        }
                    }
                }
            }

            // Repairing the components
            for(Vehicle v: this.participants){
                v.repair();
            }

            System.out.println("Ending Turn: "+i+"\n");
            System.out.println("--------\n");
            
            // Updating the position of the participants
            for(Vehicle v: participants) {

                if (v.canMove()) v.setActualPosition(v.getActualPosition()+v.getRealSpeed());
                if (v.getActualPosition()>this.length) {
                    System.out.println(v + "\thas won the race\n");
                    end = true;
                    break;
                }
            }
        }
        
    }

    /**
     * Method to get the closest opponent to a specific vehicle.
     * @param v Vehicle to check.
     * @return Closest vehicle to v.
     */
    public Vehicle getClosestOpponentTo(Vehicle v) {
        Vehicle closest = null;
        double minDistance = this.length;
        double distance = 0.0;

        // Checking all the participants
        for (Vehicle o: this.participants) {
            distance = v.getDistanceBetween(o);
            if (!o.equals(v) && minDistance > distance) { // Getting the closest vehicle
                if (o.getActualPosition() > v.getActualPosition()) { // Checking that the opponent is in front of V
                    minDistance = distance;
                    closest = o;
                }
            } 
        }
        
        return closest;
    }

    @Override 
    public String toString() {
        String str = new String();

        str = "Race with maximum length: "+this.length+"\n";

        for (Vehicle v: this.participants)  {
            str += v.toString();

            // Getting the distance with the vehicles.
            for (Vehicle oponent: this.participants) {
                if (!oponent.equals(v)) {
                    str += "\t"+v.getName()+" distance to "+oponent.getName()+": "+df.format(v.getDistanceBetween(oponent))+"\n";
                }
            }
        } 
        return str;
    }
}