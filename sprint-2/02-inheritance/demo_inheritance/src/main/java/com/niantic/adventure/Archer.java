package com.niantic.adventure;

public class Archer extends Character
{
    private int arrows;

    public Archer(String name, int health, int level, int experience, int arrows)
    {
        super(name, health, level, experience);

        this.arrows = arrows;
    }
    public void addArrow()
    {
        arrows++;
        System.out.println(this.getName() +" has gained another arrow and now has" + this.arrows);

    }
    @Override
    public void attack(Character target)
    {
        for(int i = 0; i< arrows; i++)
        {
            super.attack(target);
        }
    }

    @Override
    public void levelUp()
    {
        super.levelUp();
        if(!isDefeated()) addArrow();//normal if statement but if its simple you can just have it on a single line without {}
        //you want to add the if because without it it would give the dead archer a new arrow
    }
}
