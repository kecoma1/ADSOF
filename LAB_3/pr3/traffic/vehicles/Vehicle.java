package pr3.traffic.vehicles;
import pr3.traffic.drivers.Owner;
import pr3.traffic.drivers.Person;

/**
 * Class that defines a vehicle
 * @author Kevin de la Coba Malam and Marcos Bernuy
 */
public abstract class Vehicle {
	private String model;
	private int purchaseYear;
	private String licensePlate = null;
	private Owner owner;
	private Person driver;

	/**
	 * Constructor of the vehicle
	 * @param mod Model of the vehicle
	 * @param year Year of the vehicle
	 */
	public Vehicle(String mod, int year) {
		this.model = mod;
		this.purchaseYear = year;
	}

	/**
	 * Constructor of the vehicle
	 * @param mod Model of the vehicle
	 * @param year Year of the vehicle
	 * @param licensePlate License plate of the vehicle
	 */
	public Vehicle(String mod, int year, String licensePlate) {
		this.model = mod;
		this.purchaseYear = year;
		this.licensePlate = licensePlate;
	}
	
	/**
	 * Constructor of the vehicle
	 * @param mod Model of the vehicle
	 * @param year Year of the vehicle
	 * @param licensePlate License plate of the vehicle
	 * @param o Owner of the vehicle
	 */
	public Vehicle(String mod, int year, String licensePlate, Owner o) {		
		this.model = mod;
		this.purchaseYear = year;
		this.licensePlate = licensePlate;
		this.owner = o;
		this.driver = o.getRealOwner();
	}
	
	@Override public String toString() {
		return "model "+this.model+(this.licensePlate != null ? ", number plate: "+this.licensePlate : "")
		+", purchase year "+this.purchaseYear+", with "
		+this.numWheels()+" wheels, index:"+this.getPollutionIndex()
		+(this.owner != null ? " owner: "+this.owner.getName()+" driver: "+this.driver : "");
	}
	
	/**
	 * Abstract method to get the number of wheels in a vehicle
	 * @return Number of wheels
	 */
	public abstract int numWheels();
	
	/**
	 * Method to get the pollution index of the vehicle
	 * @return Pollution index of the vehicle
	 */
	public PollutionIndex getPollutionIndex() {
		return PollutionIndex.getPollutionIndex(this.purchaseYear);	
	}

	/**
	 * Method to set the owner of the vehicle.
	 * @param o Owner
	 */
	public void setOwner(Owner o) {
		this.owner = o.getRealOwner();
		o.addVehicle(this);
		if (this.driver == null) this.driver = o.getRealOwner();
	}

	/**
	 * Method to set the driver of the Vehicle
	 * @param p Driver of the vehicle
	 * @return True if the driver age is greater than 18, False if not
	 */
	public boolean setDriver(Person p) {
		if (p.getAge() < 18) return false;
		this.driver = p;
		return true;
	}
}
