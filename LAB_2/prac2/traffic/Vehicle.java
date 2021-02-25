package prac2.traffic;

public abstract class Vehicle {
	private String model;
	private int purchaseYear;
	
	public Vehicle(String mod, int a) {		
		this.model = mod;
		this.purchaseYear = a;
	}
	
	@Override
	public String toString() {
		return "model "+this.model+", purchase year "+this.purchaseYear+", with "+
				this.numWheels()+" wheels, index:"+this.getPollutionIndex();
	}
	
	public abstract int numWheels();
	
	public PollutionIndex getPollutionIndex() {
		return PollutionIndex.getPollutionIndex(this.purchaseYear);
	}
}
