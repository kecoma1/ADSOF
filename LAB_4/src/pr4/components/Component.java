package pr4.components;

import pr4.vehicles.IVehicle;

/**
 * Class that defines a component. 
 * @author Kevin de la Coba Malam and Marcos Aarón Bernuy.
 */
public abstract class Component implements IComponent {
    private boolean damaged = false;
    private IVehicle vehicle;

    /**
     * Constructor of the class component.
     * @param vehicle Vehicle of the class.
     */
    public Component(IVehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isDamaged() {
        return damaged;
    }

    
    public void setDamaged(boolean damage) {
        this.damaged = damage;
    }

    public IVehicle getVehicle() {
        return this.vehicle;
    }
}
