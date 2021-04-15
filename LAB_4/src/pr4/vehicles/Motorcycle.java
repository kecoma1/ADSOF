package pr4.vehicles;

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

    public String getName() {
        return "Motorcycle("+this.getId()+")";
    }

    public double getRealSpeed() {
        return this.maxSpeed;
    }

    @Override public String toString() {
        return this.getName()+super.toString();
    }
}