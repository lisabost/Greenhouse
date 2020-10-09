package rooms;

/**
 * This abstract class controls what is needed to make a room
 */
public abstract class Room {

    private String roomTitle;
    private String roomDescription;
    public static final String START_STATE = "START";

    public Room(String roomTitle, String roomDescription) {
        this.roomTitle = roomTitle;
        this.roomDescription = roomDescription;
    }
    public String getRoomDescription() {
        return roomDescription;
    }

    abstract String getRoomDirections();

    public Room getNextRoom() {
        return this;
    }

    public abstract String getInteraction();

    public abstract void onInput(String input);
}

