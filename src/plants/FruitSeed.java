package plants;

import GrowthStrategy.GrowthStrategy;
import plants.Seed;
import plants.fruits.Tomato;
import plants.vegetables.Onion;

public class FruitSeed implements Seed {

    private GrowthStrategy growthStrategy;
    /**
     * @param seedName takes in the name of the seed type as a string
     * @return returns either a jalapeno or an onion
     */
    public static Seed make(String seedName) {
        switch (seedName) {
            case "tomato" :
            case "TOMATO" :
                return new Tomato();
            case "avocado" :
            case "AVOCADO" :
                return new Onion();
        }
        return null;
    }

    @Override
    public String plant() {
        return "A small shoot appears";
    }

    @Override
    public void setGrowthStrategy(GrowthStrategy strategy) {
        this.growthStrategy = strategy;
    }

    @Override
    public String performGrow() {
        return growthStrategy.grow();
    }
}

