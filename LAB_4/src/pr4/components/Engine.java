package pr4.components;

import pr4.vehicles.IVehicle;

public class Engine extends Component{

    private int turnsLeftForRepairing = 0;


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

    public void repair() {
        if (this.turnsLeftForRepairing == 0) {
            this.setDamaged(true);
            this.turnsLeftForRepairing = this.costRepair()-1;
        } else if (this.turnsLeftForRepairing == 1) {
            this.turnsLeftForRepairing -= 1;
            this.setDamaged(false);
        } else
            this.turnsLeftForRepairing -= 1;
    }

    @Override
    public String toString(){
        return "->"+this.getName()+". "+super.toString();
    }
}