package pr4.vehicles;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public abstract class Vehicle implements IVehicle {
    private double maxSpeed;
    private double position;
    private boolean canMove = true;
    private static int nextid = 0;
    private int id;

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

    @Override public String toString() {
        DecimalFormat df2 = new DecimalFormat("#.#");
        return "Speed "+df2.format(this.maxSpeed)+". Actual position: "+df2.format(this.position)+"\n";
    }

    @Override public boolean equals(Object v) {
        if (v==this) return true;
        if (!(v instanceof Vehicle)) return false;

        // Equals compares the ID
        Vehicle vehicle = (Vehicle)v;
        return this.id == vehicle.id;
    }
}
