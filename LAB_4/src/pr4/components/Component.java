package pr4.components;

import pr4.vehicles.IVehicle;

/**
 * Class that defines a component. 
 * @author Kevin de la Coba Malam and Marcos Aarón Bernuy.
 */
public abstract class Component implements IComponent {
    private boolean damaged = false;
    private IVehicle vehicle;
    private int turnsLeftForRepairing = 0;

    /**
     * Constructor of the class component.
     * @param vehicle Vehicle of the class.
     */
    public Component(IVehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Method to reset the number of turns left until a piece is repaired
     */
    public void resetTurnsForRepairing() {
        this.turnsLeftForRepairing = this.costRepair();
    } 

    /**
     * Method to get a string with the turns left and 
     * the total turns until a component is repaired.
     * @return "turns_passed / total turns"
     */
    public String getTurnsForRepairing(){
        return this.costRepair()-this.turnsLeftForRepairing+"/"+this.costRepair();
    }

    public boolean isDamaged() {
        return damaged;
    }
 
    public void setDamaged(boolean damage) {
        this.damaged = damage;
        if (this.isCritical()) this.vehicle.setCanMove(!damage);
    }

    public IVehicle getVehicle() {
        return this.vehicle;
    }

    public void repair() {
        this.turnsLeftForRepairing--;
        if (this.turnsLeftForRepairing == 0) {
            this.setDamaged(false); 
        }
    }

    @Override
    public String toString() {
        return "Is damaged: "+this.isDamaged()+". Is critical: "+this.isCritical()+".\n";
    }
}
