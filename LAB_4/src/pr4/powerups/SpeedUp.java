package pr4.powerups;

import pr4.vehicles.IVehicle;

public class SpeedUp implements IPowerUp{

    public void applyPowerUp(IVehicle v){
        // Doubles the speed for one turn
        double vehiclePos = v.getActualPosition();
        v.setActualPosition(vehiclePos+v.getMaxSpeed());

        System.out.println("Vehicle: "+v.getName()+" applying power-up: "+this.namePowerUp());
    }

    public String namePowerUp(){
        return "SpeedUpPowerUp";
    }
}