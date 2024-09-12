package com.niantic;

public class Sword extends Weapon {

    public Sword(String name, int damage) {
        super(name, damage);
    }

    @Override
    public int attack() {
        int damageDealt = getDamage();

        int currentPercentCharged = this.getPercentCharged();

        if (currentPercentCharged > 100) {
            currentPercentCharged = 100;
        } else {
            currentPercentCharged += 10;
        }

        setPercentCharged(currentPercentCharged);

        return damageDealt;

    }

    @Override
    public int powerAttack() {
        int damageDealt = 0;

        if (this.percentCharged <= 49) {
            damageDealt = getDamage();
            int newCharge = getPercentCharged() + 10;
            setPercentCharged(newCharge);
        }
        if (this.percentCharged >= 50 && this.percentCharged <= 90) {
            damageDealt = getDamage() * 2;
            setPercentCharged(getPercentCharged() - 50);
        }
        if (this.percentCharged == 100) {
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
