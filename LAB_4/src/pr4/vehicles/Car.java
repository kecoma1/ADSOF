package pr4.vehicles;

import java.util.List;
import pr4.exceptions.InvalidComponentException;
import pr4.components.*;


/**
 * Class that implements a car.
 * @author Kevin dre la Coba and Marcos Bernuy.
 */
public class Car extends Vehicle {
    
    /**
     * Constructor of the Car classspeedSprobability
     * @param maxSpeed maximum speed of the car
     * @param position position of the car
     */
    public Car (double maxSpeed, double position){
        super(maxSpeed, position);
    }

    @Override public double getRealSpeed() {
        double random = 1 + (int)(Math.random() * ((10 - 1) + 1));
        if (random == 1) return this.getMaxSpeed(); // 1 out 10 (90% probability) 
        else return this.getMaxSpeed()*0.9;
    }

    @Override public String toString() {
        return this.getName()+super.toString();
    }

    /* IVehicle methods */

    public String getName() {
        return "Car("+this.getId()+")";
    }

    public void addComponent(IComponent c) throws InvalidComponentException {
        if (!(c instanceof BananaDispenser) || !(c instanceof Engine) 
        || !(c instanceof Wheels) || !(c instanceof Window))
            throw new InvalidComponentException("Component "+c.getName()+" is not valid for Vehicle "+this.getName()+".\n");
        this.getComponents().add(c);
    }

}
