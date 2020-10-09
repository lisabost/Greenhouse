package plants.vegetables;

import GrowthStrategy.GrowthStrategy;
import plants.Seed;

public class Onion implements Seed {
    private String shape;
    private String color;
    private String flavor;
    private GrowthStrategy growthStrategy;

    public Onion() {
        shape = "round";
        color = "yellow";
        flavor = "sweet";
    }

    public String getShape() {
        return shape;
    }

    public String getColor() {
        return color;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public String plant(){
        return "A small shoot appears";
    }

    @Override
    public void setGrowthStrategy(GrowthStrategy growthStrategy) {
        this.growthStrategy = growthStrategy;
    }

    public String performGrow() {
        return growthStrategy.grow();
    }
}
