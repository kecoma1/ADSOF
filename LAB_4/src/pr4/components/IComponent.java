package pr4.components;

import pr4.vehicles.IVehicle;

/**
 * Interface to define components and their behaviours.
 * @author Kevin de la Coba and Marcos Aarón Bernuy.
 */
public interface IComponent {
    /**
     * Method to check if a component is damaged.
     * @return True if it is, False if not.
     */
    public boolean isDamaged();

    /**
     * Method to set if a component is damaged or not.
     * @param damage Value of the damage, true or false.
     */
    public void setDamaged(boolean damage);

    /**
     * Method to get the name of the component.
     * @return String with the name.
     */
    public String getName();

    /**
     * Method to get the cost of repairing.
     * @return Cost of the repairing, turns.
     */
    public int costRepair();

    /**
     * Vehicle of the component.
     * @return Vehicle of the component.
     */
    public IVehicle getVehicle();

    /**
     * If the damaged in a specific component is critical.
     * @return Boolean value.
     */
    public boolean isCritical();

    /**
     * Method to repair the component.
     */
    public void repair();
}
