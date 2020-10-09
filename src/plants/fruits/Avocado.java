package plants.fruits;

import GrowthStrategy.GrowthStrategy;
import plants.Seed;

public class Avocado implements Seed {
    private String color;
    private String shape;
    private GrowthStrategy growthStrategy;

    public Avocado() {
        color = "green";
        shape = "oval";
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
