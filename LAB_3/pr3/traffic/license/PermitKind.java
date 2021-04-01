package pr3.traffic.license;
import pr3.traffic.vehicles.*;

/**
 * Enumeration class that defines the permit types
 * and the minimum ages to drive each one.
 * @author Kevin de la Coba and Marcos Bernuy
 */
public enum PermitKind {
    // Type of permits
    A(Motorcycle.class, 18), B(Car.class, 18), C1(Truck.class, 23);

    // Attribute of the Permit class to set the minimum age
    private int minimumAge;
    private Class<?> vehicleType;

    /**
     * Constructor of the Permit enumeration class
     * @param minimumAge Minimum age to be set
     */
    private PermitKind(Class<?> vehicleType, int minimumAge) { 
        this.vehicleType = vehicleType;
        this.minimumAge = minimumAge; 
    }

    /**.
     * Getter for the minimum age attribute
     * @return Minimum age of the permit
     */
    public int getMinimumAge() { return this.minimumAge; }

    /**
     * Getter of the type of the vehicle
     * @return Class of the vehicle
     */
    public Class<?> getVehicleType() { return this.vehicleType; }
}