package com.niantic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DaggerTest {


    private Dagger dagger;

    @BeforeEach
    public void setup() { dagger = new Dagger("Mr. Pointy", 10);
    }

    @Test
    public void newDagger_shouldHaveDefaults() {
        //arrange
        String expectedName = "Mr. Pointy";
        int damage = 10;

        //act
        String actualName = dagger.name;
        int actualDamage = dagger.getDamage();

        //assert
        assertEquals(expectedName, actualName, "Because the dagger name should be the same");
        assertEquals(damage, actualDamage, "Because the dagger's damage should be " + damage);

    }

    @Test
    public void dagger_shouldReturn_damageDefaultAmountWhenAttacks() {

        //arrange
        int expectedDamage = 10;

        //act
        dagger.attack();

        //assert
        int actualDamage = dagger.getDamage();
        assertEquals(expectedDamage, actualDamage, "Because Dagger should deal the default damage when attacking");
    }

    @Test
    public void dagger_shouldIncrease_percentChargedWhenAttackingIfDaggerCount() {
        //arrange
        int expectedPercentReturned = 40;

        //act
        dagger.attack();
        dagger.attack();
        int actualPercentCharged = dagger.getPercentCharged();

        //assert
        assertEquals(expectedPercentReturned, actualPercentCharged, "Because each attack should add 20% if there are daggers in the bag");
    }

    @Test
    public void dagger_shouldNotDecrease_daggerCountWhenAttacking() {
        //arrange
        int daggerCount = 1;

        //act
        int actualtDaggers = dagger.getDaggerCount();
        dagger.attack();
        dagger.attack();

        //assert
        assertEquals(daggerCount, actualtDaggers, "Because we cannot lose our dagger through a simple attack" );
    }

    @Test
    public void dagger_shouldIncreaseDaggerCount_whenDaggerAdded(){
        //arrange
        int expectedDaggerCount = 3;

        //act
        dagger.addDagger();
        dagger.addDagger();
        int actualDaggerCount = dagger.getDaggerCount();

        //assert
        assertEquals(expectedDaggerCount, actualDaggerCount, "Because each dagger increase should add one dagger");
    }

    @Test
    public void dagger_shouldReturn_getRangeOf10(){
        //arrange
        int expectedRange = 10;

        int actualRange = dagger.getRange();

        assertEquals(expectedRange, actualRange, "Because a dagger can be thrown");
    }

    @Test
    public void dagger_shouldNot_damageIfLessThan100(){
        //arrange
        int expectedDamage = 0;

        //act
        dagger.setPercentCharged(78);
        int actualDamage = dagger.powerAttack();

        //assert
        assertEquals(expectedDamage, actualDamage,"Becuase if charged is less than 100, it is impossible to use attack");
    }


    @Test
    public void dagger_shouldReturn_increasedDamageWhenCharge100(){
        int expectedDamage = 30;

        //act
        dagger.setPercentCharged(100);
        int actualDamage = dagger.powerAttack();

        //assert
        assertEquals(expectedDamage, actualDamage, "Because a power attack should return 3x the damage");
    }

    @Test
    public void dagger_shouldReturn_degreaseInDaggerCountAfterPowerAttack(){
        int expectedCount = 0;

        dagger.setPercentCharged(100);
        dagger.powerAttack();
        int actualCount = dagger.getDaggerCount();

        assertEquals(expectedCount, actualCount,"Because you lose a dagger each time you use a power attack");
    }


}
