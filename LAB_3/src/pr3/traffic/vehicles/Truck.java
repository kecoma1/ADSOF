package pr3.traffic.vehicles;
import pr3.traffic.drivers.Owner;
import java.time.LocalDate;
import pr3.traffic.itvs.*;
import java.time.temporal.ChronoUnit;


/**
 * Class that defines the Truck
 * @author Kevin de la Coba an Marcos Bernuy
 */
public class Truck extends Vehicle {
    private int numAxles;
    
    /**
     * Function constructor of the Truck Class
     * 
     * @param model The model of the truck
     * @param year The year of the purchase
     * @param licensePlate The license plate of the truck
     * @param axles The number of axles of the truck
     */
    public Truck(String model, int year, String licensePlate, int axles){
        super(model, year, licensePlate);
        this.numAxles = axles;
    }

    /**
     * Function constructor of the Truck Class
     * 
     * @param model The model of the truck
     * @param year The year of the purchase
     * @param licensePlate The license plate of the truck
     * @param axles The number of axles of the truck
     * @param o Owner of the truck
     */
    public Truck(String model, int year, String licensePlate, int axles, Owner o) {
        super(model, year, licensePlate, o);
        this.numAxles = axles;
    }

    /**
     * Print by default of the Truck
     *
     * @return String the default String
     */
    @Override
    public String toString(){
        return "Truck with " + this.numAxles + " axles, " + super.toString();
    }

    /**
     * Function that returns the number of wheels
     *
     * @return int Number of axles of the truck
     */
    @Override
    public int numWheels(){
        return this.numAxles*2; 
    }

    /**
     * Function that returns the pollution index of the truck
     *
     * @return PollutionIndex with the valuee
     */
    @Override
    public PollutionIndex getPollutionIndex() {
        if(this.numAxles > 2)
            return PollutionIndex.C;
        else 
		    return super.getPollutionIndex();
	}

    @Override 
    public boolean checkPassedItv(){
        Itv lastItv = this.getLastItv();
		LocalDate date = LocalDate.now();

		// Checking the age of the car
		int carAge = date.getYear() - this.getPurchaseYear();
        if (carAge < 2) return true; // No need of ITV
        else if (carAge < 6) { // Every 2 years
			if (lastItv == null) return false;
			if (date.minusYears(2).compareTo(lastItv.getDate()) > 0) return false;
		} else if (carAge < 10) { // Every 1 years
			if (lastItv == null) return false;
			if (date.minusYears(1).compareTo(lastItv.getDate()) > 0) return false;
		} else { // Every 6 months
			if (lastItv == null) return false;
			if (date.minusMonths(6).compareTo(lastItv.getDate()) > 0) return false;
		} 

		return true;
    }

    /**
	 * Method to get the days left until next inspection
	 * @return Long with the days left
	 */
    @Override
	public long timeRemaining(){
		Itv lastItv = this.getLastItv();
		LocalDate date = LocalDate.now();

		// Checking the age of the car
		int carAge = date.getYear() - this.getPurchaseYear();

		if (carAge < 2){
			// Date of the 4th year since the buy
			LocalDate end4Years = LocalDate.of(this.getPurchaseYear()+4, 1, 1);
			return ChronoUnit.DAYS.between(date, end4Years);
		} else if (carAge < 6) { // Every 2 years
			if (lastItv == null) return 0;

			// Date of the 2nd year since the last Itv
			LocalDate end2Years = lastItv.getDate().plusYears(2);

			if (date.minusYears(2).compareTo(lastItv.getDate()) > 0) return 0;
			else return ChronoUnit.DAYS.between(date, end2Years);
		} else if (carAge < 10) { // Every 1 years
			if (lastItv == null) return 0;

			// Date of the 2nd year since the last Itv
			LocalDate endYear = lastItv.getDate().plusYears(1);

			if (date.minusYears(2).compareTo(lastItv.getDate()) > 0) return 0;
            else return ChronoUnit.DAYS.between(date, endYear);
		} else { // Every 6 months
			// Date of the 1st year since the last Itv
			LocalDate end6Month = lastItv.getDate().plusMonths(6);
			
			if (date.minusMonths(6).compareTo(lastItv.getDate()) > 0) return 0;
			else return ChronoUnit.DAYS.between(date, end6Month);
		} 
	}
}
