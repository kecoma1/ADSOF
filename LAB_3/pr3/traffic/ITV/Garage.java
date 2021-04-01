/**
 * Class that defines a Garage
 * @author Kevin de la Coba Malam and Marcos Aarón Bernuy
 */
public class Garage {
    private String name;
    private String address;
    private String province;

    /**
     * Constructor of the Garage structure
     * @param name String with the name of the garage
     * @param address String of the address of the garage
     * @param province String of the province of the garage
     */
    public Garage(String name, String address, String province){
        this.name = name;
        this.address = address;
        this.province = province;
    }

    /**
     * Getter function of the name
     * @return name String with the name
     */
    public String getName(){ return this.name; }

    /**
     * Getter function of the address
     * @return address String with the address
     */
    public String getAddress(){ return this.address; }

    /**
     * Getter function of the province
     * @return provinc String with the province
     */
    public String getProvince(){ return this.province; }

    
}
