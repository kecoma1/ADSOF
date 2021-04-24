package pr4.vehicles;

import java.util.List;
import java.util.ArrayList;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import pr4.components.*;
import pr4.races.Race;

public abstract class Vehicle implements IVehicle {
    private double maxSpeed;
    private double position;
    private boolean canMove = true;
    private static int nextid = 0;
    private int id;
    private List<IComponent> components = new ArrayList<>();
    private Race race;

    /**
     * Constructor of the vehicle class.
     * @param maxSpeed Maximum speed of the vehicle.
     * @param position Starting position of the vehicle.
     */
    public Vehicle(double maxSpeed, double position) {
        this.maxSpeed = maxSpeed;
        this.position = position;
        nextid = nextid + 1;
        this.id = nextid;
    }

    public void setRace(Race r) {
        this.race = r;
    }

    public Race getRace() {
        return this.race;
    }

    /**
     * Method to get Id of the class.
     * @return Id of the vehicle.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Method to get the distance between 2 vehicles.
     * @param v Vehicle to check the distance with.
     * @return Distance between the 2 vehicles. 
     */
    public double getDistanceBetween(Vehicle v) {
        return Math.abs(this.getActualPosition() - v.getActualPosition());
    }

    /**
     * Method to get the value of the Real speed of the vehicle
     * @return Speed of the vehicle taking into account the probability
     */
    public abstract double getRealSpeed();

    public void attack(Vehicle attacked) {
        List<IComponent> enemyComponents = attacked.getComponents();
        double random = 1 + (int)(Math.random() * ((enemyComponents.size() - 1) + 1));

        Component c = (Component)enemyComponents.get((int)(random-1));
        c.setDamaged(true);
        c.resetTurnsForRepairing();
        System.out.println(this.getName()+" attacks "+attacked.getName()+" "+c.getName());
    }

    public boolean canAttack() {
        for (IComponent c: this.components)
            if (c instanceof BananaDispenser) {
                return !c.isDamaged();
            }
        
        return false;
    }

    public void repair() {
        for (IComponent c: this.components) {
            if (c.isDamaged()) {
                Component comp = (Component)c;
                comp.repair();
                System.out.println(this.getName()+" "+comp.getName()+" is being repaired "+comp.getTurnsForRepairing());
            }
        }
    }

    @Override public String toString() {
        String s = new String();
        DecimalFormat df = this.race.getDecimalFormat();

        for (IComponent c: this.getComponents()) {
            s += c.toString();
        }

        return ". Speed "+df.format(this.maxSpeed)+". Actual position: "+df.format(this.position)+"\n"+s;
    }

    @Override public boolean equals(Object v) {
        if (v==this) return true;
        if (!(v instanceof Vehicle)) return false;

        // Equals compares the ID
        Vehicle vehicle = (Vehicle)v;
        return this.id == vehicle.id;
    }

    /* IVehicle methods */

    public List<IComponent> getComponents() {
        return this.components;
    }

    public double getActualPosition() {
        return this.position;
    }

    public void setActualPosition(double newPosition) {
        this.position = newPosition;
    }

    public boolean canMove() {
        return this.canMove;
    }

    public void setCanMove(boolean newMovement) {
        this.canMove = newMovement;
    }

    public double getMaxSpeed() {
        return this.maxSpeed;
    }
}
