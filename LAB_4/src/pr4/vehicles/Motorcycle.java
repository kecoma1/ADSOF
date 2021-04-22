package pr4.vehicles;

import pr4.components;
import pr4.exceptions.InvalidComponentException;


/**
 * Class that defines a motorcycle.
 * @author Kevin de la Coba and Marcos Bernuy.
 */
public class Motorcycle extends Vehicle {

    /**
     * Constructor of the Motorcycle class.
     * @param name Name of the Motorcycle.
     * @param maxSpeed Maximum speed of the Motorcycle.
     * @param position Starting position of the Motorcycle.
     */
    public Motorcycle(double maxSpeed, double position){
        super(maxSpeed, position);
    }

    @Override public double getRealSpeed() {
        return this.getMaxSpeed();
    }

    @Override public String toString() {
        return this.getName()+super.toString();
    }

    /* IVehicle methods */

    public String getName() {
        return "Motorcycle("+this.getId()+")";
    }

    public void addComponent(IComponent c) throws InvalidComponentException {
        this.getComponents().add(c);
    } 
}