public class Engine extends Component{

    /**
     * Constructor of the engine.
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
            this.turnsLeftForRepairing = this.constRepair()-1;
        } else if (this.turnsLeftForRepairing == 1) {
            this.turnsLeftForRepairing -= 1;
            this.setDamaged(false);
        } else
            this.turnsLeftForRepairing -= 1;
    }


}