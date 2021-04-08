package pr3.traffic.vehicles;
import pr3.traffic.drivers.Owner;

/**
 * Class that defines a motorcycle
 * @author Kevin de la Coba and Marcos Bernuy
 */
public class Motorcycle extends Vehicle{
    private boolean electric;

    /**
     * Constructor of the Motorcycle class (doesn't contain the license plate).
     * @param model Model of the Motorcycle
     * @param year Year of the Motorcycle
     * @param electric Boolean value to know whether the motorcycle its electric
     */
    public Motorcycle(String model, int year, boolean electric) {
		super(model, year);
		this.electric = electric;
	}

    /**
     * Second constructor of the Motorcycle class (contains the license plate)
     * @param model Model of the Motorcycle
     * @param electric Boolean value to know whether the motorcycle its electric
     * @param year Year of the Motorcycle
     * @param licensePlate License Plate of the Motorcycle
     */
	public Motorcycle(String model, int year, String licensePlate, boolean electric) {
		super(model, year, licensePlate);
		this.electric = electric;
	}

    /**
     * Constructor of the motorcycle class that includes an owner
     * @param model Model of the Motorcycle
     * @param year Year of the Motorcycle
     * @param licensePlate License plate of the motorcycle
     * @param electric Variable to know if it is electric
     * @param o Owner of the motorcycle
     */
    public Motorcycle(String model, int year, String licensePlate, boolean electric, Owner o) {
		super(model, year, licensePlate, o);
		this.electric = electric;
	}

    @Override public int numWheels() { return 2; }

    @Override public PollutionIndex getPollutionIndex() {
		if (this.electric) return PollutionIndex.A;
        else return super.getPollutionIndex();
	}

    @Override public String toString() { 
        return "Motorcycle "+(this.electric ? "electric" : "")+super.toString();
    }
}