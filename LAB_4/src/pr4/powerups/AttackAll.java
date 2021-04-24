package pr4.powerups;

public class AttackAll {

    public void applyPowerUp(IVehicle v){


        
        System.out.println("Vehicle: "+v.getName()+" applying power-up: "+this.namePowerUp);
    }

    public String namePowerUp(){
        return "AttackAllPowerUp";
    }
}