package plants;

import GrowthStrategy.GrowthStrategy;
import GrowthStrategy.*;
import org.junit.Assert;
import org.junit.Test;
import plants.vegetables.Jalapeno;

import static org.junit.Assert.*;

public class VegetableSeedTest {




    @Test
    public void make() {
        Seed onionSeed;
        onionSeed = VegetableSeed.make("onion");
        Assert.assertNotNull(onionSeed);



    }

    @Test
    public void plant() {
        Seed onion = VegetableSeed.make("onion");
        String message = onion.plant();
        Assert.assertNotNull(message);
    }

    @Test
    public void setGrowthStrategy() {
        Seed jalapeno = new Jalapeno();
        GrowthStrategy strategy = new GrowFast();
        jalapeno.setGrowthStrategy(strategy);
        String message = jalapeno.performGrow();
        Assert.assertEquals(message, "After watching the plants for a few minutes you see that they are growing at many times the normal rate. \n" +
        "In only a half hour they will be fully grown.");
    }

    @Test
    public void performGrow() {
        Seed jalapeno = new Jalapeno();
        GrowthStrategy strategy = new GrowFast();
        jalapeno.setGrowthStrategy(strategy);
        String message = jalapeno.performGrow();
        Assert.assertEquals(message, "After watching the plants for a few minutes you see that they are growing at many times the normal rate. \n" +
                "In only a half hour they will be fully grown.");
        Assert.assertNotEquals(message, "You watch the small plant for a long time. Nothing seems to be happening. It's growth appears normal.");
    }
}