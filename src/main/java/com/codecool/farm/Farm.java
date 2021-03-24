package com.codecool.farm;

import com.codecool.farm.animal.Animal;
import com.codecool.farm.animal.Cattle;
import com.codecool.farm.animal.Pig;

import java.util.ArrayList;
import java.util.List;

class Farm {

    private final List<Animal> animals;

    public Farm(List<Animal> animals) {
        this.animals = animals;
    }

    public void feedAnimals() {
        for (Animal animal : animals) {
            animal.feed();
        }
    }

    public void butcher(Butcher butcher) {
        animals.removeIf(butcher::canButcher);
    }

    public boolean isEmpty() {
        return animals.isEmpty();
    }

    public List<String> getStatus() {
        List<String> statuses = new ArrayList<>();

        for (Animal animal : animals) {
            String status = "There is a " + animal.getSize() + " sized ";
            if (animal instanceof Cattle) {
                status += "cattle";
            } else if (animal instanceof Pig) {
                status += "pig";
            }
            status += " in the farm.";
            statuses.add(status);
        }
        return statuses;
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
