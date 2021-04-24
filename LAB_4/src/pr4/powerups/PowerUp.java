package pr4.powerups;

public class PowerUp implements IPowerUp{

    public void applyPowerUp(IVehicle v){
        System.out.println("Vehicle: "+v.getName()+" applying power-up: "+this.namePowerUp);
    }
}