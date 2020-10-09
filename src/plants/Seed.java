package plants;

import GrowthStrategy.GrowthStrategy;

public interface Seed {


    String plant();

    void setGrowthStrategy(GrowthStrategy strategy);

    String performGrow();

}
