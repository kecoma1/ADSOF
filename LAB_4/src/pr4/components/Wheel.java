package pr4.components;

import pr4.vehicles.IVehicle;

/**
 * @author Kevin de la Coba Malam and Marcos Aarón Bernuy.
 */
public class Wheel extends Component { 

    private turnsLeftForRepairing = 0;

    /**
     * Constructor of the wheel.
     * @param vehicle Vehicle where the wheel is.
     */
    public Wheel(IVehicle vehicle) {
        super(vehicle);
    }

    public String getName() {
        return "Wheel";
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