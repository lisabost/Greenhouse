/**
 * This implementation of the Room class is the hallway the player starts out in. It controls what room the player is going to enter at the beginning of the game.
 */
public class Hallway extends Room {

    private static Hallway instance = null;

    private static final String START_STATE = "START";
    private static String state = START_STATE;
    private Room nextRoom;

    private Hallway(String roomTitle, String roomDescription) {
        super(roomTitle, roomDescription);
    }

    /**
     * Creates an instance of the hallway room if there is not already a hallway
     * implementation of singleton design pattern
     * @return the hallway description
     */
    public static Hallway getInstance() {
        if(instance == null) {
            instance = new Hallway("Main room", "You stand at the entrance to a short hallway. The hallway is dimly lit by light \n" +
                    "filtering through the dirt and grime on the windowed ceiling. You can just make out \nthat there are doors on the east and west sides of the hall.");
        }
        return instance;
    }

    /**
     * this method creates a prompt for the character to select what they want to do next
     * @return string selection
     */
    @Override
    public String getRoomDirections() {
        return "Do you: \n1) Go East\n2) Go west";
    }

    /**
     * Provides description of hallway and directions for player's next step
     * @return description and directions
     */
    @Override
    public String getInteraction() {
        return getRoomDescription() + "\n" + getRoomDirections();
    }

    /**
     * This method selects what the player's input does based on the game's current state
     * @param input player's input
     */
    @Override
    public void onInput(String input) {
        if (START_STATE.equals(state)) {
            inputOnStart(input);
        }
    }

    /**
     * This method takes the player's input and creates the next room the player is going to be in
     * @param input player's choice
     */
    private void inputOnStart(String input) {
        if (input.equals("1")) {
            nextRoom = VegRoom.getInstance();
        } else if (input.equals("2")) {
            nextRoom = FruitRoom.getInstance();
        } else {
            nextRoom = null;
        }
    }

    /**
     * This method returns the next room the player is going to be in based on the inputOnStart method
     * @return the next room the player is going to be in
     */
    @Override
    public Room getNextRoom() {
        return nextRoom;
    }


}