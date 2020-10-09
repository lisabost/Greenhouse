package plants.vegetables;

import GrowthStrategy.GrowthStrategy;
import plants.Seed;

public class Jalapeno implements Seed {
    private boolean spicy = false;
    private String color;
    private GrowthStrategy growthStrategy;

    public Jalapeno() {
        spicy = true;
        color = "green";
    }

    public boolean getIsSpicy() {
        return spicy;
    }

    @Override
    public String plant(){
        return "A small shoot appears";
    }

    @Override
    public void setGrowthStrategy(GrowthStrategy growthStrategy) {
        this.growthStrategy = growthStrategy;
    }

    @Override
    public String performGrow() {
        return growthStrategy.grow();
    }
}
