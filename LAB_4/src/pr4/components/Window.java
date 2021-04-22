package pr4.components;

import pr4.vehicles.IVehicle;

/**
 * @author Kevin de la Coba Malam and Marcos Aarón Bernuy.
 */
public class Window extends Component { 

    private int turnsLeftForRepairing = 0;

    /**
     * Constructor of the window.
     * @param vehicle Vehicle where the window is.
     */
    public Window(IVehicle vehicle) {
        super(vehicle);
    }

    public String getName() {
        return "Window";
    }

    public int costRepair() {
        return 2;
    }

    public boolean isCritical() {
        return false;
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