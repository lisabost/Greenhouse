package plants.fruits;

import GrowthStrategy.GrowthStrategy;
import plants.Seed;

public class Tomato implements Seed {
    private String color;
    private String shape;
    private GrowthStrategy growthStrategy;

    public Tomato() {
        color = "red";
        shape = "round";
    }

    public String getColor() {
        return color;
    }

    public String getShape() {
        return shape;
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
