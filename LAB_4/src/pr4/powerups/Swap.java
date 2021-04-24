package pr4.powerups;

import pr4.vehicles.*;

public class Swap implements IPowerUp{

    public void applyPowerUp(IVehicle v){
        Vehicle veh = (Vehicle) v;
        Vehicle opponent = veh.getRace().getClosestOpponentTo(veh);
        Double pos = opponent.getActualPosition();

        // Swapping positions
        opponent.setActualPosition(v.getActualPosition());
        v.setActualPosition(pos);

        System.out.println("Vehicle: "+v.getName()+" applying power-up: "+this.namePowerUp());
    }

    public String namePowerUp(){
        return "SwapPowerUp";
    }
}