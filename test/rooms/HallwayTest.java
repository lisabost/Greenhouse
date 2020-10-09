package rooms;

import org.junit.Assert;
import org.junit.Test;
import rooms.Hallway;
import rooms.Room;

public class HallwayTest {

    Room hall = Hallway.getInstance();

    @Test
    public void getRoomDirections() {
        Assert.assertNotNull(hall.getRoomDirections());
        Assert.assertNotEquals(hall.getRoomDirections(), "This is a long hallway");
    }

    @Test
    public void getInteraction() {
        Assert.assertNotNull(hall.getInteraction());
        Assert.assertNotEquals(hall.getInteraction(), "Go down the hallway");
    }
}