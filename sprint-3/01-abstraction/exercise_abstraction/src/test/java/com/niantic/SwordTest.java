package com.niantic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SwordTest {


    private Sword sword;

    @BeforeEach
    public void setup() {
        sword = new Sword("Oathkeeper", 10);
    }

    @Test
    public void newSword_shouldHaveDefaults() {
        //arrange
        String expectedName = "Oathkeeper";
        int damage = 10;
        int expectedPercentCharged = 0;

        //act
        String actualName = sword.getName();
        int actualDamage = sword.getDamage();
        int actualPercentCharged = sword.getPercentCharged();

        //assert
        assertEquals(expectedName, actualName, "Because the Sword name should be the same");
        assertEquals(damage, actualDamage, "Because the Sword's damage should be " + damage);
        assertEquals(expectedPercentCharged, actualPercentCharged, "Because the default should be 0");

    }

    @Test
    public void sword_shouldReturn_damageDefaultAmountWhenAttacks() {

        //arrange
        int expectedDamage = 10;

        //act
        sword.attack();

        //assert
        int actualDamage = sword.getDamage();
        assertEquals(expectedDamage, actualDamage, "Because Sword should deal the default damage when attacking");
    }

    @Test
    public void sword_shouldIncrease_percentChargedWhenAttackingIfUnder100() {
        //arrange
        int expectedPercentReturned = 30;

        //act
        sword.attack();
        sword.attack();
        sword.attack();
        int actualPercentCharged = sword.getPercentCharged();

        //assert
        assertEquals(expectedPercentReturned, actualPercentCharged, "Because each attack should add 10% if the chargePercent is under 100");
    }

    @Test
    public void sword_shouldNotIncrease_percentWhenReaches100() {
        //arrange
        int expectedPercent = 100;

        //act
        for (int i = 0; i < 12; i++) {
            sword.attack();
        }
        int actualPercent = sword.getPercentCharged();

        assertEquals(expectedPercent, actualPercent, "Because percent charged should never exceed 100");
    }

    @Test
    public void sword_getRange_shouldReturn1() {
        int expected = 1;

        int actual = sword.getRange();

        assertEquals(expected, actual, "Because a sword should only have a range of 1");
    }

    @Test
    public void sword_powerAttackShouldReturn_defaultDamageIfLessThan50() {
        //arrange
        int expectedDamage = 10;

        //act
        int actualDamage = sword.powerAttack();

        //assert
        assertEquals(expectedDamage, actualDamage, "Because a power attack with a charge under 50 should just return basic damage.");
    }

    @Test
    public void sword_powerAttackShouldReturn_increasedChargeIfLessThan50() {
        int expectedCharge = 20;

        //act
        sword.setPercentCharged(10);
        int actualDamage = sword.powerAttack();
        int actualCharge = sword.getPercentCharged();

        //assert
        assertEquals(expectedCharge, actualCharge, "Because it is a regular attack, the powerCharge should increase by 10");

    }

    @Test
    public void sword_powerAttackShouldReturn_doubleDamageIfBetween50and99() {

        int expectedDamage = 20;

        sword.setPercentCharged(55);
        int actualDamage = sword.powerAttack();

        assertEquals(expectedDamage, actualDamage, "Because the damage should be double");

    }

    @Test
    public void sword_powerAttackShouldReturn_decreasePowerChargeIfBetween50and99() {

        int expectedPowerCharge = 5;

        sword.setPercentCharged(55);
        sword.powerAttack();
        int actualPowerCharge = sword.getPercentCharged();

        assertEquals(expectedPowerCharge, actualPowerCharge, "Because the powerCharge should be decreased by 50");

    }

    @Test
    public void sword_powerAttackShouldReturn_quadrupleDamageIf100() {

        int expectedDamage = 40;

        sword.setPercentCharged(100);
        int actualDamage = sword.powerAttack();

        assertEquals(expectedDamage, actualDamage, "Because the damage should be quadruple");

    }

    @Test
    public void sword_powerAttackShouldReturn_zerpChargeWhen100() {

        int expectedCharge = 0;

        sword.setPercentCharged(100);
        sword.powerAttack();
        int actualCharge = sword.getPercentCharged();

        assertEquals(expectedCharge, actualCharge, "Because the powerCharge should be reduced to zero");

    }


}
