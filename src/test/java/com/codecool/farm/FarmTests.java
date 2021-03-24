package com.codecool.farm;

import com.codecool.farm.animal.Animal;
import com.codecool.farm.animal.Cattle;
import com.codecool.farm.animal.Pig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import cccr.CCCRTestExecutionListener;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith({CCCRTestExecutionListener.class})
class FarmTests {
    private Animal pig;
    private Animal cattle;
    private Butcher butcher;
    private Farm farm;

    @BeforeEach
    void initialize(){
        pig = new Pig();
        cattle = new Cattle();
        butcher = new Butcher();
        List<Animal> animals = new ArrayList<>(){{
            add(pig);
            add(cattle);
        }};
        farm = new Farm(animals);
    }

    @Test
    void getSizeReturnsZeroByDefaultForPig() {
        assertEquals(0,pig.getSize());
    }

    @Test
    void getSizeReturnsZeroByDefaultForCattle() {
        assertEquals(0,cattle.getSize());
    }


    @Test
    void feedPigIncreasesSizeByOne() {
        pig.feed();
        assertEquals(1,pig.getSize());
    }

    @Test
    void canButcherReturnsFalseIfAnimalIsTooSmall() {
        for(int i = 0; i < 3; i++){
            pig.feed();
        }
        assertFalse(butcher.canButcher(pig));
    }

    @Test
    void canButcherReturnsTrueIfAnimalIsBigEnough() {
        for(int i = 0; i < 3; i++){
            pig.feed();
        }
        assertFalse(butcher.canButcher(pig));
    }

    @Test
    void feedAnimalsWorks() {
        farm.feedAnimals();
        List<Animal> animals = farm.getAnimals();
        assertEquals(1,animals.get(0).getSize());
        assertEquals(2,animals.get(1).getSize());
    }

    @Test
    void butcherAnimalsWorks() {
        for(int i = 0; i < 3; i++){
            farm.feedAnimals();
        }
        farm.butcher(butcher);
        assertTrue(farm.getAnimals().contains(pig));
        assertFalse(farm.getAnimals().contains(cattle));
    }

    @Test
    void isEmptyWorks() {
        Farm emptyFarm = new Farm(new ArrayList<>());
        assertTrue(emptyFarm.isEmpty());
        assertFalse(farm.isEmpty());
    }

    @Test
    void getStatusWorks() {
        for(int i = 0; i < 3; i++){
            farm.feedAnimals();
        }
        List<String> expected = new ArrayList<>(){{
            add("There is a 3 sized pig in the farm.");
            add("There is a 6 sized cattle in the farm.");
        }};
        List<String> statuses = farm.getStatus();
        assertEquals(expected,statuses);
    }
}
