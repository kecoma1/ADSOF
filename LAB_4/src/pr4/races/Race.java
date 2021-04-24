package pr4.races;

import pr4.components.Component;
import pr4.powerups.*;
import pr4.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

/**
 * Class that implements a race.
 * @author Kevin de la Coba and Marcos Bernuy.
 */
public class Race {
    private double length;
    private List<Vehicle> participants;
    private List<IPowerUp> powerUps = new ArrayList<>();
    private boolean allowAttacks = false;
    private boolean allowPowerUps = false;
    
    /**
     * Constructor of the object Race
     * @param length length of the Race
     * @param participants List of vehicles of the race
     */
    public Race (double length, List<Vehicle> participants){
        this.length = length;
        this.participants = participants;
        this.powerUps.add(new AttackAll());
        this.powerUps.add(new SpeedUp());
        this.powerUps.add(new Swap());
    }

    public void allowAttacks(boolean b) {
        this.allowAttacks = b;
    }

    public void allowPowerUps(boolean b) {
        this.allowPowerUps = b;
    }

    public List<Vehicle> getParticipants() {
        return this.participants;
    }

    /**
     * Method to simulate a race.
     */
    public void simulate() {
        boolean end = false;
        int i = 1;
        
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
                        if (v.canAttack()) {
                            Vehicle attacked = this.getClosestOpponentTo(v);
                            double random = 1 + (int)(Math.random() * ((2 - 1) + 1));
                            if (attacked == null || random == 1.0) {
                                System.out.println(v.getName()+" fails attack");
                            } else {
                                Component c = v.attack(attacked);
                                System.out.println(v.getName()+" attacks "+attacked.getName()+" "+c.getName());
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

            if (i%3 != 0) { // Not an attacking phase
                if (this.allowPowerUps) { // Power up phase
                    double random = 1 + (int)(Math.random() * ((2 - 1) + 1));
                    if (random == 1.0) { // 10% posibilities
                        for (Vehicle v: this.participants) {
                            random = 1 + (int)(Math.random() * ((2 - 1) + 1));
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

    public Vehicle getClosestOpponentTo(Vehicle v) {
        Vehicle closest = null;
        double minDistance = 30;
        double distance = 0.0;
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