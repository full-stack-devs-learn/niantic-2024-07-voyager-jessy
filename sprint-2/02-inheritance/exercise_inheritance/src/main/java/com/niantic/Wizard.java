package com.niantic;

public class Wizard extends Character
{
    protected int mana;

    public Wizard(String name, int health, int level, int experience, int mana)
    {
        super(name, health, level, experience);

        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void castSpell(Character target)
    {
        if (isDefeated())
        {
            System.out.println(this.name + "has been defeated and cannot cast spell.");
            return;
        }

        System.out.println(this.name + "casts spell on" + target.getName());
        if(!isDefeated() && mana >= 10)
        {
            target.takeDamage(attackDamage * 2);
            this.mana -= 10;

        }
    }
    public void regenerateMana(int amount)
    {
        if(!isDefeated())
        {
            mana += 10;
            System.out.println(this.name + "has regenerated mana to " + this.mana);
        }
    }

    @Override
    public void levelUp()
    {
        if(isDefeated()){
            System.out.println(this.name + " has been defeated!");
            return;
        }

        super.levelUp();
        this.mana += 10;
    }

    @Override
    public String specialAbility() {
        return "Cast Spells";
    }
}
