package pr4.components;

import pr4.vehicles.IVehicle;

/**
 * Class that defines a banana dispenser
 * @author Kevin de la Coba Malam and Marcos Aarón Bernuy.
 */
public class BananaDispenser extends Component { 
    /**
     * Constructor of the banana dispenser.
     * @param vehicle Vehicle where the banana dispenser is.
     */
    public BananaDispenser(IVehicle vehicle) {
        super(vehicle);
    }

    public String getName() {
        return "Banana dispenser";
    }

    public int costRepair() {
        return 3;
    }

    public boolean isCritical() {
        return false;
    }

    @Override
    public String toString(){
        return "->"+this.getName()+". "+super.toString();
    }
}