package pr4.components;

import pr4.vehicles.IVehicle;

/**
 * @author Kevin de la Coba Malam and Marcos Aarón Bernuy.
 */
public class Wheels extends Component { 

    private int turnsLeftForRepairing = 0;

    /**
     * Constructor of the wheels.
     * @param vehicle Vehicle where the wheels is.
     */
    public Wheels(IVehicle vehicle) {
        super(vehicle);
    }

    public String getName() {
        return "Wheels";
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
}