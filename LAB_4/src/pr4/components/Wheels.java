package pr4.components;

import pr4.vehicles.IVehicle;

/**
 * @author Kevin de la Coba Malam and Marcos Aarón Bernuy.
 */
public class Wheels extends Component { 
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
    
    @Override
    public String toString(){
        return "->"+this.getName()+". "+super.toString();
    }
}