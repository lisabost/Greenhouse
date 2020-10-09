package rooms;

import org.junit.Assert;
import org.junit.Test;
import rooms.FruitRoom;
import rooms.Room;

public class FruitRoomTest {

    FruitRoom fruit = FruitRoom.getInstance();

    @Test
    public void getRoomDirections() {
        Assert.assertNotNull(fruit.getRoomDirections());
        Assert.assertNotEquals(fruit.getRoomDirections(), "This is a room full of fruit");
    }

    @Test
    public void getInteraction() {
        Assert.assertNotNull(fruit.getInteraction());
        Assert.assertNotEquals(fruit.getInteraction(), "");
    }

    @Test
    public void examineTable() {
        String message = fruit.examineTable();
        Assert.assertFalse(message.isBlank());
        Assert.assertFalse(message.isEmpty());
    }

    @Test
    public void examineNote() {
        String message = fruit.examineNote();
        Assert.assertFalse(message.isBlank());
        Assert.assertFalse(message.isEmpty());
    }

    @Test
    public void examineBoxes() {
        String message = fruit.examineBoxes();
        Assert.assertFalse(message.isBlank());
        Assert.assertFalse(message.isEmpty());
    }

    @Test
    public void examineBags() {
        String message = fruit.examineBags();
        Assert.assertFalse(message.isBlank());
        Assert.assertFalse(message.isEmpty());
    }

    @Test
    public void examinePlanter() {
        String HAVE_TOMATO_SEED = "HAVE_TOMATO_SEED";
        String NOT_PLANTED_SEED = "NOT_PLANTED_SEED";
        String message = fruit.examinePlanter(HAVE_TOMATO_SEED, NOT_PLANTED_SEED);
        Assert.assertFalse(message.isEmpty());
        Assert.assertFalse(message.isBlank());
    }

    @Test
    public void examinePlantedPlanter() {
        String message = fruit.examinePlantedPlanter();
        Assert.assertFalse(message.isBlank());
        Assert.assertFalse(message.isEmpty());
    }

    @Test
    public void examinePlants() {
        String fertilizerState = "HAVE_FERTILIZER";
        String message = fruit.examinePlants(fertilizerState);
        Assert.assertFalse(message.isEmpty());
        Assert.assertFalse(message.isBlank());
    }

    @Test
    public void examineGrowth() {
        String message = fruit.examineGrowth();
        Assert.assertFalse(message.isBlank());
        Assert.assertFalse(message.isEmpty());
    }
}