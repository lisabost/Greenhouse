import planters.Planter;
import planters.VegetablePlanter;
import plants.Seed;
import plants.VegetableSeed;

/**
 * This class creates the vegetable room and controls interactions within the vegetable room of the greenhouse
 */
public class VegRoom extends Room implements VegetableState {

    /**
     * makes sure there is not already an instance of the room
     */
    private static VegRoom instance = null;
    private Seed onionSeed;
    private Planter vegPlanter = new VegetablePlanter("The row of wooden planters line the north and east walls of the room. The sides of the planters are " +
                                                                                 "decorated with pictures of vegetables. They are filled with rich soil.");
    /**
     * These variables set the default values of the variables for the vegetable room
     */
    private static String onionSeedState = NO_ONION_SEED;
    private static String fertilizerState = NO_FERTILIZER;
    private static String plantState = NOT_PLANTED_SEED;
    private static String state = START_STATE;

    /**
     * Sets the nextRoom such that we will stay in the vegetable room until leave room is selected
     */
    private Room nextRoom = this;


    /**
     * Constructor for vegetable room, constructor is private per the singleton design pattern so there can only be one vegetable room
     * at a time
     * Singleton design pattern
     * @param roomTitle Title of the room
     * @param roomDescription Description of the room
     */
    private VegRoom(String roomTitle, String roomDescription) {
        super(roomTitle, roomDescription);
    }

    /**
     * Creates an instance of the vegetable room if there is not already a vegetable room
     * Implementation of singleton design pattern
     *
     * @return the vegetable room description
     */
    public static VegRoom getInstance() {
        if (instance == null) {
            instance = new VegRoom("Vegetable Room", "You stand at the west side of a small square room. " +
                    "The walls are made entirely of dirty and dingy glass windows. \nThe north and east sides of the room are lined with rows of" +
                    "wooden planter boxes. \nThere is a small table in the center of the room it holds some boxes, full looking bags, and paper.");
        }
        return instance;
    }

    /**
     * this method creates a prompt for the character to select what they want to do next
     *
     * @return string selection
     */
    @Override
    public String getRoomDirections() {
        return getRoomDescription() + "\nDo you: \n" +
                "1) Examine table \n" +
                "2) Examine planters\n" +
                "3) Return to hallway";
    }

    /**
     * This method displays results based on the state of the game and gives the next batch of choices
     * @return string description of what the player is looking at and choices for the player
     */
    @Override
    public String getInteraction() {
        switch (state) {
            case LOOK_AT_TABLE:
                return examineTable();
            case LOOK_AT_PLANTER:
                return examinePlanter(onionSeedState, plantState);
            case LOOK_AT_NOTE:
                return examineNote();
            case LOOK_AT_BOXES:
                return examineBoxes();
            case LOOK_AT_BAGS:
                return examineBags();
            case PLANTED_SEED:
                return examinePlantedPlanter();
            case LOOK_AT_PLANTS:
                return examinePlants(fertilizerState);
            case PLANT_GROWTH:
                return examineGrowth();
            default:
                return getRoomDirections();
        }
    }

    /**
     * This method takes the input the user gave and hands that input to the methods that change the state of the game
     * the current state indicates which text description and choices are displayed.
     * @param input string choice from player
     */
    @Override
    void onInput(String input) {
        switch (state) {
            case START_STATE:
                inputOnStart(input);
                break;
            case LOOK_AT_TABLE:
                inputOnTable(input);
                break;
            case LOOK_AT_PLANTER:
                inputOnPlanter(input, onionSeed);
                break;
            case LOOK_AT_NOTE:
                inputOnNote(input);
                break;
            case LOOK_AT_BOXES:
                inputOnBoxes(input);
                break;
            case LOOK_AT_BAGS:
                inputOnBags(input);
                break;
            case PLANTED_SEED:
                inputOnPlantedPlanter(input);
                break;
            case LOOK_AT_PLANTS:
                inputOnPlants(input);
                break;
            case PLANT_GROWTH:
                afterGrowth(input);
        }
    }

    /**
     * This method takes the user's input and sets the state based on that input
     * @param input String chosen by user at prompt
     */
    private void inputOnStart(String input) {
        if (input.equals("1")) {
            state = LOOK_AT_TABLE;
        } else if (input.equals("2")) {
            state = LOOK_AT_PLANTER;
        } else {
            nextRoom = Hallway.getInstance();
            state = START_STATE;
        }
    }

    /**
     * This method takes the player's input and sets the state of the game accordingly
     * @param input player's choice
     */
    private void inputOnTable(String input) {
        switch (input) {
            case "1":
                state = LOOK_AT_NOTE;
                break;
            case "2":
                state = LOOK_AT_BOXES;
                break;
            case "3":
                state = LOOK_AT_BAGS;
                break;
            default:
                state = START_STATE;
                break;
        }
    }

    /**
     * This method takes the player's input and sets the state of the game accordingly
     * @param input string player's choice
     */
    private void inputOnNote(String input) {
        state = LOOK_AT_TABLE;
    }

    /**
     * This method takes the player's input and sets the state of the game accordingly, it also sets the onion seed state
     * to keep track of if the player has a seed or not
     * @param input player's choice
     */
    private void inputOnBoxes(String input) {
        if ("1".equals(input)) {
            onionSeed = VegetableSeed.make("onion");
            onionSeedState = HAVE_ONION_SEED;
        }
        state = LOOK_AT_TABLE;
    }

    /**
     * This method takes the player's input and sets the state of the game accordingly, it also sets the fertilizer state to
     * track if the player has fertilizer or not and what type of fertilizer they have
     * @param input string player's choice
     */
    private void inputOnBags(String input) {
        switch (input) {
            case "1":
                fertilizerState = HAVE_FERTILIZER;
                state = LOOK_AT_TABLE;
                break;
            case "2":
                fertilizerState = HAVE_INSTANT_FERTILIZER;
                state = LOOK_AT_TABLE;
                break;
            default:
                state = LOOK_AT_TABLE;
        }
    }

    /**
     * This method takes the player's input sends it to the planter along with the seed the player picked up
     * and sets the state of the game to what the planter says that it should be.
     * @param input string player's choice,
     * @param onionSeed the tomato seed the player picked up
     */
    private void inputOnPlanter(String input, Seed onionSeed) {
        vegPlanter.receiveSeed(onionSeed);
        state = vegPlanter.inputOnPlanter(input);
    }

    /**
     * This method takes the player's input sends it to the planter. It then takes in the state that the planter says
     * the game is in based on the input received.
     * @param input player's choice
     */
    private void inputOnPlants(String input) {
        state = vegPlanter.inputOnPlants(input);
    }

    /**
     * This method takes the player's input and sends it to the planter. It then takes in the state that the planter says
     * the game is in based on the input received.
     * @param input player's choice
     */
    private void inputOnPlantedPlanter(String input) {
        state = vegPlanter.inputOnPlantedPlanter(input);
    }

    /**
     * This method performs option to exit the game
     * @param input takes choice of player and selects exit game
     */
    private void afterGrowth(String input) {
        System.exit(0);
    }


    /**
     * This method returns the next room the player is going to
     * Defaults to this room until the player selects otherwise
     * @return
     */
    @Override
    public Room getNextRoom() {
        return nextRoom;
    }

    /**
     * This method controls what is displayed when the player looks at the table
     * @return string description and set of choices for the player
     */
    public String examineTable() {
        return "The small but sturdy table holds a single piece of paper with writing on it, several small boxes, and a few bags. \n" +
                "Do you:\n" +
                "1) Read note \n" +
                "2) Examine boxes \n" +
                "3) Examine bags \n" +
                "4) Leave table";
    }

    /**
     * This method controls what is displayed when the player looks at the note
     * @return string description and set of choices for the player
     */
    public String examineNote() {
        return "The note reads:\n" +
                "Steps to Planting and Cultivating Vegetables.\n" +
                "Step 1 Take a seed from the table and plant in the soil\n" +
                "Step 2 Fertilize seeds\n" +
                "1) Return to table";
    }

    /**
     * This method controls what is displayed when the player looks at the boxes on the table
     * @return string description and set of choices for the player
     */
    public String examineBoxes() {
        return "There are boxes full of onion seeds.\n" +
                "Do you:\n" +
                "1) Take an onion seed\n" +
                "3) Return to table";
    }

    /**
     * This method controls what is displayed when the player looks at the bags on the table
     * @return String description and set of choices for the player
     */
    public String examineBags() {
        return "There are two bags full of fertilizer. The first is labeled \"fast growth\" and the second is labeled \"instant growth\"\n" +
                "Do you:\n" +
                "1) Choose fast-growth fertilizer\n" +
                "2) Choose instant-growth fertilizer\n" +
                "3) Return to table";
    }

    /**
     * This method sends the onionSeedState and the plantState to the planter. It takes in the description of the planter depending on
     * the current values of onionSeedState and plantState
     * @param onionSeedState string whether or not the player has an onion seed
     * @param plantState string whether or not the player has planted a seed
     * @return string description of the planter and the next set of choices for the player
     */
    public String examinePlanter(String onionSeedState, String plantState) {
        vegPlanter.receiveSeedState(onionSeedState);
        vegPlanter.receivePlantState(plantState);
        return vegPlanter.examinePlanter();
    }

    /**
     * This method tells the planter to look at it's planted self
     * @return string description of the planted planter and next set of choices for the player
     */
    public String examinePlantedPlanter() {
        return vegPlanter.examinePlantedPlanter();
    }

    /**
     * This method sends the fertilizerState to the planter . It takes in the description of the plants inside the planter depending
     * on the current status of whether or not the player has fertilizer.
     * @param fertilizerState string whether or not the player has fertilizer
     * @return string description of the plants and next set of choices for the player
     */
    public String examinePlants(String fertilizerState) {
        vegPlanter.receiveFertilizerState(fertilizerState);
        return vegPlanter.examinePlants();
    }

    /**
     * This method displays the growth of the plant based on the choice of fertilizer
     * @return string description of plant growth and option to exit the game
     */
    public String examineGrowth() {
        return vegPlanter.examineGrowth();
    }

}

