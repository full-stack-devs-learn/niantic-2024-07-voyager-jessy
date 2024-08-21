package com.niantic.part_2_challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameCharacterTests
{
    private GameCharacter character;

    @BeforeEach
    public void  setup() {character = new GameCharacter(100, "Evangeline");}
    @Test
    public void gameCharacter_shouldReturn_takeHitValueLessDamageAmount()
    {
        //arrange
        int damage = 32;

        //act
      character.takeHit(32);

        //assert
        int expectedEnergyLevel = 68;
        int actualEnergyLevel = character.getEnergyLevel();
        assertEquals(expectedEnergyLevel,actualEnergyLevel, "Because it should calculate 100 -  32");
    }

    @Test
    public void gameCharacter_shouldReturn_increasedEnergyLevelIfNotKnockedOut()
    {
        //arrange
        int amount = 18;
        int energyLevel = 75;
        int expectedEnergyLevel = 93;


        //act
        character.getEnergyLevel();
        character.heal(18);


        //assert
        int actualEnergyLevel = character.getEnergyLevel();
        assertEquals(expectedEnergyLevel, actualEnergyLevel, "Because it should calculate 75 + 18");

    }


}