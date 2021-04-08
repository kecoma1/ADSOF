package pr4.vehicles;

/**
 * Class that implements a car.
 * @author Kevin dre la Coba and Marcos Bernuy.
 */
public class Car extends Vehicle {
    
    /**
     * Constructor of the Car class
     * @param maxSpeed maximum speed of the car
     * @param position position of the car
     */
    public Car (double maxSpeed, double position){
        super(maxSpeed, position);
        
    }

    public String getName() {
        return "Car("+this.getId()+"). ";
    }

    @Override public String toString() {
        return this.getName()+super.toString();
    }
}
