package pr4.vehicles;

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
    public Truck(String name, double maxSpeed, double position) {
        super(name, maxSpeed, position);
    }
    
    public String getName() {
        return "Truck("+this.getId()+"). ";
    }

    @Override public String toString() {
        return this.getName()+super.toString();
    }
}