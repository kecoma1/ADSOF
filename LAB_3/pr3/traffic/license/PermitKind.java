package pr3.traffic.license;

/**
 * Enumeration class that defines the permit types
 * and the minimum ages to drive each one.
 * @author Kevin de la Coba and Marcos Bernuy
 */
public enum PermitKind {
    // Type of permits
    A(18), B(18), C1(23);

    // Attribute of the Permit class to set the minimum age
    private int minimumAge;

    /**
     * Constructor of the Permit enumeration class
     * @param minimumAge Minimum age to be set
     */
    private PermitKind(int minimumAge) { this.minimumAge = minimumAge; }

    /**
     * Getter for the minimum age attribute
     * @return Minimum age of the permit
     */
    public int getMinimumAge() { return this.minimumAge; }
}