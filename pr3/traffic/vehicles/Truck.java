package pr3.traffic.vehicles;

/**
 * Class that defines the Truck
 * @author Kevin de la Coba an Marcos Bernuy
 */
public class Truck extends Vehicle{
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
}
