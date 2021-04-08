public abstract class Vehicle implements IVehicle {
    private String name;
    private double maxSpeed;
    private double position;
    private boolean canMove = true;

    /**
     * Constructor of the vehicle class.
     * @param name Name of the vehicle.
     * @param maxSpeed Maximum speed of the vehicle.
     * @param position Starting position of the vehicle.
     */
    public Vehicle(String name, double maxSpeed, double position) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.position = position;
    }

    /**
     * Getter of the position
     */
    public double getActualPosition() {
        return this.position;
    }

    public void setActualPosition(double newPosition) {
        this.position = newPosition;
    }

    public boolean canMove() {
        return this.canMove;
    }

    public void setCanMove(boolean newMovement) {
        this.canMove = newMovement;
    }

    public double getMaxSpeed() {
        return this.maxSpeed;
    }

    public String getName() {
        return this.getName;
    }
}
