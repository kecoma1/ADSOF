package pr3.traffic.license;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that defines Licenses
 * @author Kevin de la Coba and Marcos Bernuy
 */
public class License {
    private int points;
    private static int totalIds;
    private int id;
    private List<PermitKind> allowedTypes = new ArrayList<>();
    private boolean suspended;

    /**
     * Constructor for the License class
     * @param p Undefined undefined number of PermitKinds
     */
    public License(PermitKind ...p) {
        License.totalIds++;
        this.points = 12;
        this.id = License.totalIds;
        this.suspended = false;

        // Adding the allowed cars to the license
        for (PermitKind permit: p) {
            this.allowedTypes.add(permit);
        }
    }
    
    /**
     * Method to add a PermitKind to the license
     * @param p PermitKind to be added into the license
     */
    public void addPermit(PermitKind p) {
        if (!this.allowedTypes.contains(p))
            this.allowedTypes.add(p);
    }

    /**
     * Getter of the points
     * @return Points of the license
     */
    public int getPoints() { return this.points; }

    /**
     * Getter of the Id
     * @return Id of the license
     */
    public int getId() { return this.id; }

    /**
     * Method to get the permits of the list 
     * @return List of the permits
     */
    public List<PermitKind> getPermitKinds() { return this.allowedTypes; }
    
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

    /**
     * Method getter of the minimun age of the permits
     * @return int the minimun age of all permits
     */
    public int getPermitAge(){
        int maximun = 18;
        for(PermitKind p: this.allowedTypes){
            if (p.getMinimumAge() > maximun)
                maximun=p.getMinimumAge();
        }
        return maximun;
    }

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

    @Override public String toString() {
        return "License [id ="+this.id+", PermitKinds="+
        this.allowedTypes+", points="+this.points+"]";
    }
}