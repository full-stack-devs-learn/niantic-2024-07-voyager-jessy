package com.niantic.adventure;

import com.niantic.Knight;
import com.niantic.Wizard;
import com.niantic.Character;

public class AdventureGame {

    public static void main(String[] args)
    {
        Knight hero = new Knight("Jamie", 50, 1, 100, 10);
        Wizard villan = new Wizard("Whitewalker", 60, 2, 100, 70);

        villan.attack(hero);
        villan.attack(hero);
        villan.attack(hero);
        villan.attack(hero);


        hero.levelUp();
    }
}
