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
	 * @param Owner Owner of the vehicle
	 */
	public Vehicle(String mod, int a, String licensePlate, Owner o) {		
		this.model = mod;
		this.purchaseYear = a;
		this.licensePlate = licensePlate;
		this.owner = o.getRealOwner();
	}
	
	@Override public String toString() {
		if (licensePlate == null) return "model "+this.model+", purchase year "+this.purchaseYear+", with "+
										  this.numWheels()+" wheels, index:"+this.getPollutionIndex();
		else return "model "+this.model+", number plate: "+this.licensePlate+", purchase year "+this.purchaseYear+", with "+
					 this.numWheels()+" wheels, index:"+this.getPollutionIndex();
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
	}

	/**
	 * Method to set the driver of the Vehicle
	 * @param p Driver of the vehicle
	 * @return True if the driver age is < 18, False if not
	 */
	public boolean setDriver(Person p) {
		if (p.getAge() < 18) return false;
		this.driver = p;
		return true;
	}
}
