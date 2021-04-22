package pr4.vehicles;

import java.math.RoundingMode;
import java.util.List;
import pr4.components;

public abstract class Vehicle implements IVehicle {
    private double maxSpeed;
    private double position;
    private boolean canMove = true;
    private static int nextid = 0;
    private int id;
    private List<IComponent> components = new ArrayList<>();

    /**
     * Constructor of the vehicle class.
     * @param maxSpeed Maximum speed of the vehicle.
     * @param position Starting position of the vehicle.
     */
    public Vehicle(double maxSpeed, double position) {
        this.maxSpeed = maxSpeed;
        this.position = position;
        this.nextid = this.nextid + 1;
        this.id = this.nextid;
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

    /**
     * Method to get the value of the Real speed of the vehicle
     * @return Speed of the vehicle taking into account the probability
     */
    public abstract double getRealSpeed();

    @Override public String toString() {
        return ". Speed "+this.maxSpeed+". Actual position: "+this.position+"\n";
    }

    @Override public boolean equals(Object v) {
        if (v==this) return true;
        if (!(v instanceof Vehicle)) return false;

        // Equals compares the ID
        Vehicle vehicle = (Vehicle)v;
        return this.id == vehicle.id;
    }
}
