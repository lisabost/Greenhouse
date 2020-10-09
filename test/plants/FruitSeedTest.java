package plants;

import GrowthStrategy.*;
import org.junit.Assert;
import org.junit.Test;
import plants.fruits.Avocado;
import plants.fruits.Tomato;

public class FruitSeedTest {

    @Test
    public void make() {
        Seed tomato = FruitSeed.make("tomato");
        Seed avocado = FruitSeed.make("avocdao");
        Assert.assertNotNull(tomato);
        Assert.assertNull(avocado);

    }

    @Test
    public void plant() {
        Seed tomato = FruitSeed.make("tomato");
        String message = tomato.plant();
        Assert.assertNotNull(message);
    }

    @Test
    public void setGrowthStrategy() {
        Seed avocado = new Avocado();
        GrowthStrategy strategy = new GrowFast();
        avocado.setGrowthStrategy(strategy);
        String message = avocado.performGrow();
        Assert.assertEquals(message, "After watching the plants for a few minutes you see that they are growing at many times the normal rate. \n" +
                "In only a half hour they will be fully grown.");
    }

    @Test
    public void performGrow() {
        Seed tomato = new Tomato();
        GrowthStrategy strategy = new GrowFast();
        tomato.setGrowthStrategy(strategy);
        String message = tomato.performGrow();
        Assert.assertEquals(message, "After watching the plants for a few minutes you see that they are growing at many times the normal rate. \n" +
                "In only a half hour they will be fully grown.");
        Assert.assertNotEquals(message, "You watch the small plant for a long time. Nothing seems to be happening. It's growth appears normal.");
    }
}