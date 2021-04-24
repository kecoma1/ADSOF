package pr4.powerups;

import pr4.vehicles.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Swap implements IPowerUp{

    public void applyPowerUp(IVehicle v){
        Vehicle vehicle = (Vehicle) v;
        DecimalFormat df = vehicle.getRace().getDecimalFormat();
        Vehicle opponent = vehicle.getRace().getClosestOpponentTo(vehicle);
        if (opponent == null) return;

        Double pos = opponent.getActualPosition();

        // Swapping positions
        opponent.setActualPosition(v.getActualPosition());
        v.setActualPosition(pos);

        System.out.println("Vehicle: "+v.getName()+" applying power-up: "+this.namePowerUp());
        System.out.println(v.getName()+" was on "+df.format(opponent.getActualPosition())+" with swap is now on "+df.format(v.getActualPosition()));
        System.out.println(opponent.getName()+" was on "+df.format(v.getActualPosition())+" with swap is now on "+df.format(opponent.getActualPosition()));
    }

    public String namePowerUp(){
        return "SwapPowerUp";
    }
}