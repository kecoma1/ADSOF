package pr4.components;

import pr4.vehicles.IVehicle;

/**
 * Class that defines a banana dispenser
 * @author Kevin de la Coba Malam and Marcos Aarón Bernuy.
 */
public class BananaDispenser extends Component { 

    private int turnsLeftForRepairing = 0;

    /**
     * Constructor of the banana dispenser.
     * @param vehicle Vehicle where the banana dispenser is.
     */
    public BananaDispenser(IVehicle vehicle) {
        super(vehicle);
    }

    public String getName() {
        return "Banana dispenser. ";
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
        return "->"+this.getName()+super.toString();
    }
}