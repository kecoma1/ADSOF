package pr4.vehicles;

import java.lang.Math;
import pr4.components.*;
import pr4.exceptions.InvalidComponentException;


/**
 * Class that defines a truck.
 * @author Kevin de la Coba and Marcos Bernuy.
 */
public class Truck extends Vehicle {

    /**
     * Constructor of the Truck class.
     * @param name Name of the truck.
     * @param maxSpeed Maximum speed of the truck.
     * @param position Starting position of the truck.
     */
    public Truck(double maxSpeed, double position) {
        super(maxSpeed, position);
    }

    @Override public double getRealSpeed() {
        double random = 1 + (int)(Math.random() * ((10 - 1) + 1));
        if (random == 1) return this.getMaxSpeed(); // 1 out 10 (90% probability) 
        else return this.getMaxSpeed()*0.8;
    }

    @Override public String toString() {
        return this.getName()+super.toString();
    }

    /* Ivehicle methods */

    public String getName() {
        return "Truck("+this.getId()+")";
    }

    public void addComponent(IComponent c) throws InvalidComponentException {
        if (!(c instanceof BananaDispenser) || !(c instanceof Engine) 
        || !(c instanceof Wheels) || !(c instanceof Window))
            throw new InvalidComponentException("Component "+c.getName()+" is not valid for Vehicle "+this.getName()+".\n"+
        this.getComponents().add(c));
    }  
}