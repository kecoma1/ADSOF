package pr4.vehicles;

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

    public String getName() {
        return "Car("+this.getId()+")";
    }

    @Override public double getRealSpeed() {
        double random = 1 + (int)(Math.random() * ((10 - 1) + 1));
        if (random == 1) return this.getMaxSpeed(); // 1 out 10 (90% probability) 
        else return this.getMaxSpeed()*0.9;
    }

    @Override public String toString() {
        return this.getName()+super.toString();
    }
}
