package prac2.traffic;

public class Car extends Vehicle {
	private boolean diesel;
	
	public Car(String mod, int a, boolean diesel) {
		super(mod, a);
		this.diesel = diesel;
	}

	@Override public int numWheels() { return 4; }

	@Override public String toString() {
		return "Car "+(this.diesel ? "diesel" : "gasoline") + ", "+ super.toString();
	}
	
	@Override
	public PollutionIndex getPollutionIndex() {
		if (this.diesel) return PollutionIndex.C;
		return super.getPollutionIndex();
	}
	
	public boolean getDiesel() { return this.diesel; }
	public void setDiesel(boolean b) { this.diesel = b; }
}
