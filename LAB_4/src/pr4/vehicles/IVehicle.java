package pr4.vehicles;

/**
 * Interface to define a vehicle.
 * @author Kevin de la Coba and Marcos Bernuy.
 */
public interface IVehicle {
    /**
     * Method to get the position of the vehicle.
     * @return Position of the vehicle.
     */
    public double getActualPosition();

    /**
     * Method to get the actual position of the vehicle.
     * @param newPosition Position to be setted.
     */
    public void setActualPosition(double newPosition);

    /**
     * Method to check if the vehicle can move.
     * @return Boolean value to see if the vehicle can move.
     */
    public boolean canMove();

    /**
     * Method to allow or not the vehicle to move. 
     * @param newMovement Value to be set.
     */
    public void setCanMove(boolean newMovement);

    /**
     * Method to get the maximum speed of a vehicle.
     * @return Maximum speed of the vehicle.
     */
    public double getMaxSpeed();

    /**
     * Method to get the name of a vehicle.
     * @return Name of the vehicle.
     */
    public String getName();

    /**
     * Method to add a component in a vehicle.
     * @param c Component to be added.
     * @throws InvalidComponentException Thrown in case the vehicle cannot
     * have that component.
     */
    public void addComponent(IComponent c) throws InvalidComponentException;

    /**
     * Method to get the components of a vehicle.
     * @return List containing all the components.
     */
    public List<IComponent> getComponents();
}
