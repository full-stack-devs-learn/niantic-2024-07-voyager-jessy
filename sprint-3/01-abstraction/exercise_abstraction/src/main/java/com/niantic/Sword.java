package com.niantic;

public class Sword extends Weapon
{

    public Sword(String name, int damage) {
        super(name, damage);
    }

    @Override
    public int attack() {
        int damageDealt = getDamage();

        int currentPercentCharged = this.getPercentCharged();

        if(currentPercentCharged > 100){
             currentPercentCharged = 100;
        }
        else{
            currentPercentCharged += 10;
        }

        setPercentCharged(currentPercentCharged);

        return damageDealt;

    }

    @Override
    public int powerAttack() {
        int damageDealt;

        if(this.percentCharged < 50){
           damageDealt =  getDamage();
        }
        else if(this.percentCharged > 51 && this.percentCharged <= 99){
            damageDealt = getDamage() * 2;
            setPercentCharged(getPercentCharged() - 50);
        }
        else{
            damageDealt = getDamage() * 4;
                    setPercentCharged(0);
        }
        return damageDealt;
    }

    @Override
    public int getRange() {
        return 1;
    }
}
