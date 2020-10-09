import planters.FruitPlanter;
import planters.Planter;
import plants.FruitSeed;
import plants.Seed;

/**
 * This class creates the fruit room and controls the interactions that happen in the fruit room of the greenhouse
 */
public class FruitRoom extends Room implements FruitState {

    private static FruitRoom instance = null;
    private Seed tomatoSeed;
    private Planter fruitPlanter = new FruitPlanter("The row of wooden planters line the north and east walls of the room. The sides of the planters are " +
            "decorated with pictures of fruit. They are filled with rich soil.");

    /**
     * These variables set the default values for the fruit room variables
     */
    private static String tomatoSeedState = FruitState.NO_TOMATO_SEED;
    private static String fertilizerState = FruitState.NO_FERTILIZER;
    private static String plantState = FruitState.NOT_PLANTED_SEED;
    private static String state = START_STATE;
    private Room nextRoom = this;


    /**
     * Constructor for fruit room, constructor is private per the requirements of the singleton design pattern so there may only be one fruit room at a time
     * Singleton design pattern
     * @param roomTitle Title of the room
     * @param roomDescription Description of the room
     */
    private FruitRoom(String roomTitle, String roomDescription) {
        super(roomTitle, roomDescription);
    }

    /**
     * Creates an instance of the fruit room if there is not already a fruit room
     * implementation of singleton design pattern
     * @return the fruit room description
     */
    public static FruitRoom getInstance() {
        if(instance == null) {
            instance = new FruitRoom("Fruit Room", "You stand at the east side of a small square room. The walls are entirely made " +
                    "of glass windows \nand there are wooden planter boxes that line the east and south walls. There" +
                    "is a small table \nin the center of the room that holds several boxes and a few stacks of papers.");
        }
        return instance;
    }
    /**
     * this method creates a prompt for the character to select what they want to do next
     * Overrides parent class method
     * @return string selection
     */
    public String getRoomDirections() {
        return getRoomDescription() + "\nDo you: \n" +
                "1) Examine table \n" +
                "2) Examine planters\n" +
                "3) Return to hallway";
    }

    /**
     * This method controls what the player is looking at depending on the current state of the game and gives the next
     * group of choices
     * @return String description of what the player is looking at and their current choices
     */
    @Override
    public String getInteraction() {
        switch (state) {
            case FruitState.LOOK_AT_TABLE:
                return examineTable();
            case FruitState.LOOK_AT_PLANTER:
                return examinePlanter(tomatoSeedState, plantState);
            case FruitState.LOOK_AT_NOTE:
                return examineNote();
            case FruitState.LOOK_AT_BOXES:
                return examineBoxes();
            case FruitState.LOOK_AT_BAGS:
                return examineBags();
            case FruitState.PLANTED_SEED:
                return examinePlantedPlanter();
            case FruitState.LOOK_AT_PLANTS:
                return examinePlants(fertilizerState);
            case FruitState.PLANT_GROWTH:
                return examineGrowth();
            default:
                return getRoomDirections();
        }
    }

    /**
     * This method takes the player's choice and uses it to determine what the player is doing and sets that as the state of
     * the game
     * @param input player's choice
     */
    @Override
    void onInput(String input) {
        switch (state) {
            case START_STATE:
                inputOnStart(input);
                break;
            case FruitState.LOOK_AT_TABLE:
                inputOnTable(input);
                break;
            case FruitState.LOOK_AT_PLANTER:
                inputOnPlanter(input, tomatoSeed);
                break;
            case FruitState.LOOK_AT_NOTE:
                inputOnNote(input);
                break;
            case FruitState.LOOK_AT_BOXES:
                inputOnBoxes(input);
                break;
            case FruitState.LOOK_AT_BAGS:
                inputOnBags(input);
                break;
            case FruitState.PLANTED_SEED:
                inputOnPlantedPlanter(input);
                break;
            case FruitState.LOOK_AT_PLANTS:
                inputOnPlants(input);
                break;
            case FruitState.PLANT_GROWTH:
                afterGrowth(input);
        }
    }

    /**
     * This method takes the user's input and sets the state based on that input
     * @param input string player's choice
     */
    private void inputOnStart(String input) {
        if (input.equals("1")) {
            state = FruitState.LOOK_AT_TABLE;
        } else if (input.equals("2")) {
            state = FruitState.LOOK_AT_PLANTER;
        } else {
            nextRoom = Hallway.getInstance();
            state = START_STATE;
        }
    }

    /**
     * This method takes the player's input and sets the state of the game accordingly
     * @param input string player's choice
     */
    private void inputOnTable(String input) {
        switch (input) {
            case "1":
                state = FruitState.LOOK_AT_NOTE;
                break;
            case "2":
                state = FruitState.LOOK_AT_BOXES;
                break;
            case "3":
                state = FruitState.LOOK_AT_BAGS;
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
        state = FruitState.LOOK_AT_TABLE;
    }

    /**
     * This method takes the player's input and sets the state of the game accordingly, it also sets the tomato seed state to
     * track if the player has a tomato
     * @param input string player's choice
     */
    private void inputOnBoxes(String input) {
        if ("1".equals(input)) {
            tomatoSeed = FruitSeed.make("tomato");
            tomatoSeedState = FruitState.HAVE_TOMATO_SEED;
        }
        state = FruitState.LOOK_AT_TABLE;
    }

    /**
     * This method takes the player's input and sets the state of the game accordingly, it also sets the fertilizer state to
     * track if the player has fertilizer or not and what type of fertilizer they have
     * @param input string player's choice
     */
    private void inputOnBags(String input) {
        switch (input) {
            case "1":
                fertilizerState = FruitState.HAVE_FERTILIZER;
                state = FruitState.LOOK_AT_TABLE;
                break;
            case "2":
                fertilizerState = FruitState.HAVE_INSTANT_FERTILIZER;
                state = FruitState.LOOK_AT_TABLE;
                break;
            default:
                state = FruitState.LOOK_AT_TABLE;
        }
    }

    /**
     * This method takes the player's input sends it to the planter along with the seed the player picked up
     * and sets the state of the game to what the planter says that it should be.
     * @param input string player's choice,
     * @param tomatoSeed the tomato seed the player picked up
     */
    private void inputOnPlanter(String input, Seed tomatoSeed) {
        fruitPlanter.receiveSeed(tomatoSeed);
        state = fruitPlanter.inputOnPlanter(input);
    }

    /**
     * This method takes the player's input sends it to the planter. It then takes in the state that the planter says
     * the game is in based on the input received.
     * @param input player's choice
     */
    private void inputOnPlants(String input) {
        state = fruitPlanter.inputOnPlants(input);
    }

    /**
     * This method takes the player's input and sends it to the planter. It then takes in the state that the planter says
     * the game is in based on the input received.
     * @param input player's choice
     */
    private void inputOnPlantedPlanter(String input) {
        state = fruitPlanter.inputOnPlantedPlanter(input);
    }

    /**
     * This method performs option to exit the game
     * @param input takes choice of player and selects exit game
     */
    public void afterGrowth(String input) {
        System.exit(0);
    }

    /**
     * This method returns the nextRoom the player is going to
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

    public String examineBoxes() {
        return "There are boxes full of tomato seeds.\n" +
                "Do you:\n" +
                "1) Take a tomato seed\n" +
                "3) Return to table";
    }

    /**
     * This method controls what is displayed when the player looks at the boxes on the table
     * @return string description and set of choices for the player
     */
    public String examineBags() {
        return "There are two bags full of fertilizer. The first is labeled \"fast growth\" and the second is labeled \"instant growth\"\n" +
                "Do you:\n" +
                "1) Choose fast-growth fertilizer\n" +
                "2) Choose instant-growth fertilizer\n" +
                "3) Return to table";
    }

    /**
     * This method sends the tomatoSeedState and the plantState to the planter. It takes in the description of the planter depending on
     * the current values of tomatoSeedState and plantState
     * @param tomatoSeedState string whether or not the player has a tomato seed
     * @param plantState string whether or not the player has planted a seed
     * @return string description of the planter and next set of choices for the player
     */
    public String examinePlanter(String tomatoSeedState, String plantState) {
        fruitPlanter.receiveSeedState(tomatoSeedState);
        fruitPlanter.receivePlantState(plantState);
        return fruitPlanter.examinePlanter();
        }

    /**
     * This method tells the planter to look at it's planted self
     * @return string description of the planted planter and next set of choices for the player
     */
    public String examinePlantedPlanter() {
        return fruitPlanter.examinePlantedPlanter();
    }

    /**
     * This method sends the fertilizerState to the planter . It takes in the description of the plants inside the planter depending
     * on the current status of whether or not the player has fertilizer.
     * @param fertilizerState string whether or not the player has fertilizer
     * @return string description of the plants and next set of choices for the player
     */
    public String examinePlants(String fertilizerState) {
        fruitPlanter.receiveFertilizerState(fertilizerState);
        return fruitPlanter.examinePlants();
    }

    /**
     * This method displays the growth of the plant based on the choice of fertilizer
     * @return string description of plant growth and option to exit the game
     */
    public String examineGrowth() {
        return fruitPlanter.examineGrowth();
    }


}
