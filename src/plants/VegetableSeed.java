package plants;

import GrowthStrategy.GrowthStrategy;
import plants.vegetables.Jalapeno;
import plants.vegetables.Onion;

/**
 * This factory creates jalapeno and onion seed objects by overwriting the
 * make method from the SeedFactory interface
 */
public class VegetableSeed implements Seed{

    private GrowthStrategy growthStrategy;
    /**
     * @param seedName takes in the name of the seed type as a string
     * @return returns either a jalapeno or an onion
     */
    public static Seed make(String seedName) {
        switch (seedName) {
            case "jalapeno" :
            case "JALAPENO" :
                return new Jalapeno();
            case "onion" :
            case "ONION" :
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
