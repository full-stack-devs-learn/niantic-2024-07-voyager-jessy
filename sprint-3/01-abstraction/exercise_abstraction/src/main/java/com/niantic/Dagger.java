package com.niantic;

public class Dagger extends Weapon
{
    private int daggerCount = 1;
    int charge;

    public Dagger(String name, int damage, int daggerCount) {
        super(name, damage);
        this.daggerCount = daggerCount;
    }

    public int getDaggerCount() {
        return daggerCount;
    }

    public void addDagger(){
        daggerCount++;
    }


    @Override
    public int attack() {
        int damageDone = 0;

        if(daggerCount == 0){
            damageDone = 0;
            charge = getPercentCharged();
            setPercentCharged(charge);
        }
        else{
            charge = this.getPercentCharged() + 20;
            setPercentCharged(charge);
            damageDone =  getDamage();
        }
        return damageDone;
    }

    @Override
    public int powerAttack() {
        int damageDealt = 0;

        if (getPercentCharged() == 100) {
            damageDealt = getDamage() * 3;
            daggerCount--;
        }
        return damageDealt;
    }

    @Override
    public int getRange() {
        return 10;
    }
}
