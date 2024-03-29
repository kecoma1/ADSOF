package pr3.traffic.fines;

/**
 * Class that defines a Fine
 * @author Kevin de la Coba and Marcos Bernuy
 */
public class Fine{
    private String licensePlate;
    private String type;
    private int points;

    /**
     * Constructor of the Fine class
     * @param licensePlate number plate of the car
     * @param type type of the car
     * @param points points of the fine
     */
    public Fine(String licensePlate, String type, String points){
        this.licensePlate = licensePlate;
        this.type = type;
        this.points = Integer.parseInt(points);
    }

    /**
     * Method getter of the licensePlate
     * @return String with the licensePlate
     */
    public String getLicensePlate(){ return this.licensePlate; }

    /**
     * Method getter of the type of Fine
     * @return String with the licensePlate
     */
    public String getType(){ return this.type; }

    /**
     * Method getter of the points of the Fine
     * @return String with the points
     */
    public int getPoints(){ return this.points; }

    @Override public String toString(){
        return "Fine [plate="+this.licensePlate+", Fine type="
        +this.type+", points="+this.points+"]";
    }
}