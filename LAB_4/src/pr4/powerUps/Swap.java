package pr4.powerUps;

import pr4.races.Race;
import pr4.vehicles.*;

import java.text.DecimalFormat;

/**
 * Class that defines the swap power upp.
 * @author Kevin de la Coba and Marcos Aarón Bernuy.
 */
public class Swap implements IPowerUp{

    public void applyPowerUp(IVehicle v){
        Vehicle vehicle = (Vehicle) v;
        DecimalFormat df = Race.getDecimalFormat();
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