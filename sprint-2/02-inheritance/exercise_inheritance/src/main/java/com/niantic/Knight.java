package com.niantic;

public class Knight extends Character
{
    private int armor;


    public Knight(String name, int health, int level, int experience, int armor) {
        super(name, health, level, experience);
        this.armor = armor;
    }

    public int getArmor(Wizard wizard)
    {
        armor = wizard.getMana();
        return armor;
    }

    @Override
    public void levelUp()
    {
        if (!isDefeated()) {
            armor += 5;
            super.levelUp();
            System.out.println(this.name + " now has armor of " + this.armor + "!");

        }
    }

    @Override
    public void takeDamage(int damage)
    {

        if(damage > this.armor)
        {
            this.health -= (damage - this.armor);

            if (isDefeated())
            {
                health = 0;
                System.out.println(this.name + " has been defeated!");
            }
            else
            {
                System.out.println(this.name + " took damage.");
                System.out.println(this.name + " now has " + this.health + " hp remaining.");
            }

        }
        else
        {
            System.out.println("Armor strong enough to avoid damage dealt.");
        }
    }

    @Override
    public String specialAbility() {
        return "Armor Shield";
    }

    public int getArmor() {
        return armor;

        //not sure if I need this, but wasn't sure how to use getArmor otherwise if it was dependent on Wizard. 
    }
}

