package com.niantic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KnightTest
{

    @Test
    public void knight_shouldReturn_levelUpIfNotKnockedOut()
    {
        //arrange
        Knight knight = new Knight("Brienne", 100, 1, 100, 50);
        int expected = 55;

        //act
        knight.levelUp();

        //assert
        int actual = knight.getArmor();
        assertEquals(expected, actual, "Because 5 should be added to the armor everytime a character levels up.");

    }
    @Test
    public void knight_shouldNotReturn_levelUpIfKnockedOut()
    {
        //arrange
        Knight knight = new Knight("Brienne", 0, 3, 100, 45);
        int expected = 45;

        //act
        knight.levelUp();

        //assert
        int actual = knight.getArmor();
        assertEquals(expected, actual, "Because a knocked out character cannot level up.");

    }
    @Test
    public void knight_shouldReturn_damageDealtWhenNotKnockedOut()
    {
        //arrange
        Knight knight = new Knight("Brienne", 100, 1, 100, 30);
        int damage = 40;
        int expectedHealth = 90;

        //act
        knight.takeDamage(damage);



        //assert
        int actual = knight.getHealth();
        assertEquals(expectedHealth, actual, "Because it should have calculated 100 - 10.");


    }

    @Test
    public void knight_shouldReturn_noDamageDealtWhenNotKnockedOutAndHigherArmor()
    {
        //arrange
        Knight knight = new Knight("Brienne", 150, 3, 100, 50);
        int damage = 31;
        int expectedHealth = 150;

        //act
        knight.takeDamage(damage);


        //assert
        int actual = knight.getHealth();
        assertEquals(expectedHealth, actual, "Because Brienne's armor blocked all damage.");

    }

    @Test
    public void knight_shouldNotReturn_knockedOutWhenDamageDealtAndHigherDamage()
    {
        //arrange
        Knight knight = new Knight("Brienne", 25, 3, 100, 50);
        int damage = 75;
        int expectedHealth = 0;

        //act
        knight.takeDamage(damage);


        //assert
        int actual = knight.getHealth();
        assertEquals(expectedHealth, actual, "Because Brienne's was knocked out.");

    }


//oops... I think I made my knight invincible...? didnt realize this until I added AdventureGame. Will need to come back to this




}
