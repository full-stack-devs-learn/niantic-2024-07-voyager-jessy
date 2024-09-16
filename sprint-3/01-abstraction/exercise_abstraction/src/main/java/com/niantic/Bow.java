package com.niantic;

public class Bow extends Weapon
{
    private String arrowType;
    private int quiverSize;
    private int arrowCount;

    public Bow(String name, int damage, String arrowType, int quiverSize) {
        super(name, damage);
        this.arrowType = arrowType;
        this.quiverSize = quiverSize;
    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int powerAttack() {
        return 0;
    }

    @Override
    public int getRange() {
        return 0;
    }
}
