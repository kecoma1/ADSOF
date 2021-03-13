package pr3.traffic.fines;

public class Fine{
    private String licensePlate;
    private String type;
    private String points;

    /**
     * Constructor of the Fine class
     * @author Kevin de la Coba and Marcos Bernuy
     */
    public Fine(String licensePlate, String type, String points){
        this.licensePlate = licensePlate;
        this.type = type;
        this.points = points;
    }

    /**
     * Method getter of the licensePlate
     * @return String with the licensePlate
     */
    public String getLicensePlate(){
        return this.licensePlate;
    }

    /**
     * Method getter of the type of Fine
     * @return String with the licensePlate
     */
    public String getType(){
        return this.type;
    }

    /**
     * Method getter of the points of the Fine
     * @return String with the points
     */
    public String getPoints(){
        return this.points;
    }

    @Override public String toString(){
        return "Fine [plate="+this.licensePlate+", Fine type="
        +this.type+", points="+this.points+"]";
    }
}