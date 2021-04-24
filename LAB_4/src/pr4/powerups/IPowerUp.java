package pr4.powerups;
import pr4.vehicles.IVehicle;

/**
 * Interface to define PowerUps and their behaviours.
 * @author Kevin de la Coba and Marcos Aarón Bernuy.
 */
public interface IPowerUp{

    /**
     * Method to apply a PowerUp to a vehicle
     * @param v which will receive the PowerUp.
     */
    public void applyPowerUp(IVehicle v);

    /**
     * Method to get the name of the PowerUp
     * @return String of the name of the PowerUp
     */
    public String namePowerUp();
}