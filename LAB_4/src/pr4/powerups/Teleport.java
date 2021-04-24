package pr4.powerups;

import pr4.vehicles.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Teleport implements IPowerUp{

    public void applyPowerUp(IVehicle v){
        Vehicle vehicle = (Vehicle) v;
        DecimalFormat df = vehicle.getRace().getDecimalFormat();

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