package pr3.traffic.vehicles;
import pr3.traffic.drivers.Owner;

/**
 * Class that defines a Car
 * @author Kevin de la Coba Malam and Marcos Aarón Bernuy
 */
public class Car extends Vehicle {
	private boolean diesel;
	
	/**
	 * Constructor of the class Car
	 * @param mod Name of the Car
	 * @param a  Year of the car
	 * @param diesel Variable to know if the car is diesel
	 */
	public Car(String mod, int a, boolean diesel) {
		super(mod, a);
		this.diesel = diesel;
	}

	/**
	 * Constructor of the class Car. Includes if its diesel
	 * @param mod Name of the Car
	 * @param a  Year of the car
	 * @param licensePlate License plate of the car
	 * @param diesel Variable to know if the car is diesel
	 */
	public Car(String mod, int a, String licensePlate, boolean diesel) {
		super(mod, a, licensePlate);
		this.diesel = diesel;
	}

	/**
	 * Constructor of the class Car. Includes if its 
	 * diesel and the owner
	 * @param mod Name of the Car
	 * @param a  Year of the car
	 * @param licensePlate License plate of the car
	 * @param diesel Variable to know if the car is diesel
	 * @param o Owner of the car
	 */
	public Car(String mod, int a, String licensePlate, boolean diesel, Owner o) {
		super(mod, a, licensePlate, o);
		this.diesel = diesel;
	}
	
	/**
	 * Getter for the diesel
	 * @return Boolean value that says if the car is diesel
	 */
	public boolean getDiesel() { return this.diesel; }

	/**
	 * Setter for the diesel attribute
	 * @param b Value to set
	 */
	public void setDiesel(boolean b) { this.diesel = b; }

	@Override public int numWheels() { return 4; }

	@Override public String toString() {
		return "Car "+(this.diesel ? "diesel" : "gasoline") + ", "+ super.toString();
	}
	
	@Override
	public PollutionIndex getPollutionIndex() {
		if (this.diesel) return PollutionIndex.C;
		return super.getPollutionIndex();
	}
}
