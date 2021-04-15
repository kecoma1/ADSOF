package pr4.vehicles;
import java.lang.Math;

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
    
    public String getName() {
        return "Truck("+this.getId()+")";
    }

    public double getRealSpeed() {
        double random = 1 + (int)(Math.random() * ((10 - 1) + 1));
        if (random == 1) return maxSpeed; // 1 out 10 (90% probability) 
        else return maxSpeed*0.8;
    }

    @Override public String toString() {
        return this.getName()+super.toString();
    }
}