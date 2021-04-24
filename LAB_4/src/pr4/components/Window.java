package pr4.components;

import pr4.vehicles.IVehicle;

/**
 * @author Kevin de la Coba Malam and Marcos Aarón Bernuy.
 */
public class Window extends Component { 

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

    @Override
    public String toString(){
        return "->"+this.getName()+". "+super.toString();
    }
}