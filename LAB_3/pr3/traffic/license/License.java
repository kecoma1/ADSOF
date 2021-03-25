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
    private boolean suspended;

    /**
     * Constructor for the License class
     * @param p Undefined undefined number of PermitKinds
     */
    public License(PermitKind ...p) {
        License.total_ids++;
        this.points = 12;
        this.id = License.total_ids;
        this.suspended = false;

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

    /**
     * Getter of the points
     * @return Points of the license
     */
    public int getPoints() { return this.points; }

    /**
     * Getter of the suspended attribute
     * @return Boolean value
     */
    public boolean getSuspended() { return this.suspended; }

    /**
     * Setter of the suspended attribute
     * @param value Value to be setted
     */
    public void setSuspended(boolean value) { this.suspended = value; }

    
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

    /**
     * Method to remove points from a License, if the
     * points are 0 then the license is suspended
     * @param n Number of points to remove
     */
    public void removePoints(int n) {
        if (this.points == 0 && n > 0) this.suspended = true;

        if (n > this.points) this.points = 0;
        else this.points -= n;
    }
}