package pr4.components;

import pr4.vehicles.IVehicle;

public class Engine extends Component{
    /**
     * Constructor for the engine.
     * @param vehicle Vehicle that contains the engine.
     */
    public Engine(IVehicle vehicle){
        super(vehicle);
    }

    public String getName() {
        return "Engine";
    }

    public int costRepair() {
        return 3;
    }

    public boolean isCritical() {
        return true;
    }

    @Override
    public String toString(){
        return "->"+this.getName()+". "+super.toString();
    }
}