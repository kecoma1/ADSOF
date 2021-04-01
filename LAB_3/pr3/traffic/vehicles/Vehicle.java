package pr3.traffic.vehicles;
import java.util.List;
import java.util.ArrayList;

import pr3.traffic.drivers.Owner;
import pr3.traffic.drivers.Person;
import pr3.traffic.license.License;
import pr3.traffic.license.PermitKind;
import pr3.traffic.ITV.ITV;

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
	private List<ITV> itvs = new ArrayList<>();

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

		// Adding the vehicle to the owner vehicles
		o.addVehicle(this);
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
		// Getting the person that owns 
		this.owner = o.getRealOwner();

		if (o.getVehicles().contains(this) == false) o.addVehicle(this);

		// In case a driver is not set we set it as the owner
		if (this.driver == null) this.driver = o.getRealOwner();
	}

	/**
	 * Method to set the driver of the Vehicle
	 * @param p Driver of the vehicle
	 * @return True if the driver age is greater than 18, False if not
	 */
	public boolean setDriver(Person p) {
		if (!this.checkDriversLicense(p)) return false;
		if (p.getAge() < 18) return false;
		this.driver = p;
		return true;
	}

	/**
	 * Method to get the license plate of a vehicle
	 * @return The license plate of the vehicle
	 */
	public String getLicensePlate(){
		return this.licensePlate;
	}

	/**
	 * Method to get the purchase year of a vehicle
	 * @return The purchase year of the vehicle
	 */
	public int getPurchaseYear(){
		return this.purchaseYear;
	}

	/**
	 * Method to get the driver of the vehicle
	 * @return Person driver of the vehicle
	 */
	public Person getDriver(){
		return this.driver;
	}

	/**
	 * Method to get the owner of the vehicle
	 * @return Owner of the vehicle
	 */
	public Owner getOwner(){
		return this.owner;
	}

	/**
	 * Method to get the ITVs passed by the vehicle
	 * @return List with the ITVs passed
	 */
	public ArrayList<ITV> getITV(){
		return this.itvs;
	}

	/**
	 * Method to get the last ITV passed by the vehicle
	 * @return Last ITV of that vehicle
	 */
	public ITV getLastITV() {
		if (this.itvs.isEmpty()) return null;
		return this.itvs[this.itvs.size()-1];
	}

	/**
	 * Method to pass the ITV
	 * @param itv to be passed 
	 */
	public void passITV(ITV itv){
		if (this.getLastITV().getDate().isAfter(itv.getDate()))
			return;
		this.itvs.add(itv);
	}

	/**
	 * Method to check if the ITV was passed in the 
	 * requiered time. Implementation for Cars and motorcycles
	 * @return boolean
	 */
	public boolean checkPassedITV() {
		ITV lastItv = this.getLastITV();
		LocalDate date = LocalDate.now();

		// Checking the age of the car
		int carAge = date.getYear() - this.getPurchaseYear();

		if (carAge < 4) return true; // No need of ITV
		else if (carAge < 10) { // Every 2 years
			if (lastItv == null) return false;
			if (date.minusYear(2).compareTo(lastItv.getDate()) > 0) return false;
		} else { // Every year
			if (date.minusYear(1).compareTo(lastItv.getDate()) > 0) return false;
		}

		return true;
	}

	/**
	 * Method to get the days left until next inspection
	 * @return integer with the days left
	 */
	public int timeRemaining(){
		ITV lastItv = this.getLastITV();
		LocalDate date = LocalDate.now();

		// Checking the age of the car
		int carAge = date.getYear() - this.getPurchaseYear();

		if (carAge < 4){
			date.minus
		}
		else if (carAge < 10) { // Every 2 years
			if (lastItv == null) return false;
			if (date.minusYear(2).compareTo(lastItv.getDate()) > 0) return false;
		} else { // Every year
			if (date.minusYear(1).compareTo(lastItv.getDate()) > 0) return false;
		} 
	}

	/**
	 * Method to check if a person can drive a vehicle
	 * @param p Person to check 
	 * @return True if the driver can drive the vehicle, False if not
	 */
	private boolean checkDriversLicense(Person p) {
		License license = p.getLicense();
		if (license == null) return false;

		List<PermitKind> permits = license.getPermitKinds();
		if (permits == null) return false;

		for (PermitKind permit : permits) {
			if (permit.getVehicleType() == this.getClass())
				return true;
		}
		return false;
	}

	@Override public String toString() {
		return ", model "+this.model+(this.licensePlate != null ? ", number plate: "+this.licensePlate : "")
		+", purchase year "+this.purchaseYear+", with "
		+this.numWheels()+" wheels, index:"+this.getPollutionIndex()
		+(this.owner != null ? " owner: "+this.owner.getName()+" driver: "+this.driver.getName() : "");
	}
	
	
}
