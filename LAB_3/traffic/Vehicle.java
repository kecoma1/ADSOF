package prac2.traffic;

public abstract class Vehicle {
	private String model;
	private int purchaseYear;
	private String licensePlate = null;

	public Vehicle(String mod, int a) {
		this.model = mod;
		this.purchaseYear = a;
	}
	
	public Vehicle(String mod, int a, String licensePlate) {		
		this.model = mod;
		this.purchaseYear = a;
		this.licensePlate = licensePlate;
	}
	
	@Override
	public String toString() {
		if (licensePlate == null) return "model "+this.model+", purchase year "+this.purchaseYear+", with "+
										  this.numWheels()+" wheels, index:"+this.getPollutionIndex();
		else return "model "+this.model+", number plate: "+this.licensePlate+", purchase year "+this.purchaseYear+", with "+
					 this.numWheels()+" wheels, index:"+this.getPollutionIndex();
	}
	
	public abstract int numWheels();
	
	public PollutionIndex getPollutionIndex() {
		return PollutionIndex.getPollutionIndex(this.purchaseYear);
	}
}
