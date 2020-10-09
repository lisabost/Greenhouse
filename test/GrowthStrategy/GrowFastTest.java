package GrowthStrategy;

import org.junit.Assert;
import org.junit.Test;
import plants.Seed;
import plants.fruits.Tomato;

import static org.junit.Assert.*;

public class GrowFastTest {

    @Test
    public void grow() {
        Seed tomato = new Tomato();
        tomato.setGrowthStrategy(new GrowFast());
        String message = tomato.performGrow();
        Assert.assertNotNull(message);
        Assert.assertNotEquals(message, "I'm growing fast");
    }
}