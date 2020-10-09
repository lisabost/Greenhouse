package rooms;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class VegRoomTest {

    VegRoom vegRoom = VegRoom.getInstance();

    @Test
    public void getRoomDirections() {
        String message = vegRoom.getRoomDirections();
        Assert.assertFalse(message.isEmpty());
        Assert.assertFalse(message.isBlank());
    }

    @Test
    public void getInteraction() {
        String message = vegRoom.getInteraction();
        Assert.assertFalse(message.isEmpty());
        Assert.assertFalse(message.isBlank());
    }

    @Test
    public void examineTable() {
        String message = vegRoom.examineTable();
        Assert.assertFalse(message.isEmpty());
        Assert.assertFalse(message.isBlank());
    }

    @Test
    public void examineNote() {
        String message = vegRoom.examineNote();
        Assert.assertFalse(message.isEmpty());
        Assert.assertFalse(message.isBlank());
    }

    @Test
    public void examineBoxes() {
        String message = vegRoom.examineBoxes();
        Assert.assertFalse(message.isEmpty());
        Assert.assertFalse(message.isBlank());
    }

    @Test
    public void examineBags() {
        String message = vegRoom.examineBags();
        Assert.assertFalse(message.isEmpty());
        Assert.assertFalse(message.isBlank());
    }

    @Test
    public void examinePlanter() {
        String HAVE_ONION_SEED = "HAVE_ONION_SEED";
        String NOT_PLANTED_SEED = "NOT_PLANTED_SEED";
        String message = vegRoom.examinePlanter(HAVE_ONION_SEED, NOT_PLANTED_SEED);
        Assert.assertFalse(message.isEmpty());
        Assert.assertFalse(message.isBlank());

    }

    @Test
    public void examinePlantedPlanter() {
        String message = vegRoom.examinePlantedPlanter();
        Assert.assertFalse(message.isEmpty());
        Assert.assertFalse(message.isBlank());
    }

    @Test
    public void examinePlants() {
        String fertilizerState = "HAVE_FERTILIZER";
        String message = vegRoom.examinePlants(fertilizerState);
        Assert.assertFalse(message.isEmpty());
        Assert.assertFalse(message.isBlank());
    }

    @Test
    public void examineGrowth() {
        String message = vegRoom.examineGrowth();
        Assert.assertFalse(message.isEmpty());
        Assert.assertFalse(message.isBlank());
    }
}