package pr3.traffic.license;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that defines Licenses
 * @author Kevin de la Coba and Marcos Bernuy
 */
public class License {
    private int points;
    private static int total_ids;
    private int id;
    private List<PermitKind> allowed_types = new ArrayList<>();

    /**
     * Constructor for the License class
     * @param p Undefined undefined number of PermitKinds
     */
    public License(PermitKind ...p) {
        License.total_ids++;
        this.points = 12;
        this.id = License.total_ids;

        // Adding the allowed cars to the license
        for (PermitKind permit: p) {
            this.allowed_types.add(permit);
        }
    }
    
    /**
     * Method to add a PermitKind to the license
     * @param p PermitKind to be added into the license
     */
    public void addPermit(PermitKind p) {
        if (!this.allowed_types.contains(p))
            this.allowed_types.add(p);
    }
    
    @Override public String toString() {
        return "License [id ="+this.id+", PermitKinds="+
        this.allowed_types+", points="+this.points+"]";
    }

    /**
     * Method getter of the minimun age of the permits
     * @return int the minimun age of all permits
     */
    public int getPermitAge(){
        int maximun = 18;
        for(PermitKind p: this.allowed_types){
            if (p.getMinimumAge() > maximun)
                maximun=p.getMinimumAge();
        }
        return maximun;
    }

    /**
     * Method to get the permits of the list 
     * @return List of the permits
     */
    public List<PermitKind> getPermitKinds() { return this.allowed_types; }
}