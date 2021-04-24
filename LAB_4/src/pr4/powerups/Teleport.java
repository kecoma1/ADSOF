package pr4.powerups;

import pr4.races.Race;
import pr4.vehicles.*;

import java.text.DecimalFormat;

/**
 * Class that defines the teleport power up.
 * @author Kevin de la Coba and Marcos Aarón Bernuy.
 */
public class Teleport implements IPowerUp{

    public void applyPowerUp(IVehicle v){
        DecimalFormat df = Race.getDecimalFormat();

        // Doubles the speed for one turn
        double vehiclePos = v.getActualPosition();
        v.setActualPosition(vehiclePos+v.getMaxSpeed());

        System.out.println("Vehicle: "+v.getName()+" applying power-up: "+this.namePowerUp());
        System.out.println(v.getName()+" teleports from "+df.format(vehiclePos)+" to "+df.format(v.getActualPosition()));
    }

    public String namePowerUp(){
        return "TeleportPowerUp";
    }
}