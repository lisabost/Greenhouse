package planters;

import GrowthStrategy.GrowFast;
import GrowthStrategy.GrowInstant;
import plants.Seed;

/**
 * This class implements the planters.Planter class and makes a vegetable planter. It controls interactions with the planter and the plants it contains.
 */
public class VegetablePlanter extends Planter implements VegetablePlanterState {

    /**
     * vegetable planter constructor inherits from planters.Planter
     * @param description string description of planter
     */
    public VegetablePlanter(String description) {
        super(description);
    }

    /**
     * creates a variable for our onion seed
     */
    private Seed onionSeed;

    /**
     * These variables set the various states to their default values at the start of the game
     */
    private static String seedState = VegetablePlanterState.NO_ONION_SEED;
    private static String plantState = VegetablePlanterState.NOT_PLANTED_SEED;
    private static String fertilizerState = VegetablePlanterState.NO_FERTILIZER;
    private String state = VegetablePlanterState.LOOK_AT_PLANTER;

    private static String growth;

    /**
     * This method takes in the current seeState from the vegetable room if the player has picked up a seed
     * @param seedState string constant
     */
    @Override
    public void receiveSeedState(String seedState) {
        VegetablePlanter.seedState = seedState;
    }

    /**
     * This method takes in the current plantState from the vegetable room if the player has planted a seed
     * @param plantState string constant
     */
    @Override
    public void receivePlantState(String plantState) {
        VegetablePlanter.plantState = plantState;
    }

    /**
     * This method takes in the current fertilizerState from the vegetable room if the player picked up fertilizer
     * @param fertilizerState string constant
     */
    @Override
    public void receiveFertilizerState(String fertilizerState) {
        VegetablePlanter.fertilizerState = fertilizerState;
    }

    /**
     * This method takes in the seed object from the vegetable room if the player has picked up a seed
     * @param seed seed object
     */
    @Override
    public void receiveSeed(Seed seed) {
        this.onionSeed = seed;
    }




    /**
     * This method takes the player's input and sets the state of the game accordingly depending on whether or not the player
     * has a seed or has already planted a seed
     * @param input string player's choice
     */
    @Override
    public String inputOnPlanter(String input) {
        if(!plantState.equals("PLANT_EXISTS")  && seedState.equals("HAVE_ONION_SEED")) {
            if ("1".equals(input)) {
                onionSeed.plant();
                plantState = VegetablePlanterState.PLANT_EXISTS;
                state = VegetablePlanterState.PLANTED_SEED;
                seedState = VegetablePlanterState.NO_ONION_SEED;
                return state;
            } else {
                state = VegetablePlanterState.START_STATE;
                return state;
            }
        } else if (plantState.equals("PLANT_EXISTS")) {
            state = VegetablePlanterState.PLANTED_SEED;
            return state;
        }  else state = VegetablePlanterState.START_STATE;
        return state;
    }

    /**
     * This method takes the player's input and sets the state of the game accordingly. It also sets the growth strategy
     * for the plant based on the type of fertilizer the player chose
     * @param input string player's choice
     */
    @Override
    public String inputOnPlants(String input) {
        if(input.equals("1")) {
            if(fertilizerState.equals("HAVE_FERTILIZER")) {
                onionSeed.setGrowthStrategy(new GrowFast());
                growth = onionSeed.performGrow();
                state = VegetablePlanterState.PLANT_GROWTH;
                return state;
            } else if(fertilizerState.equals("HAVE_INSTANT_FERTILIZER")) {
                onionSeed.setGrowthStrategy(new GrowInstant());
                growth = onionSeed.performGrow();
                state = VegetablePlanterState.PLANT_GROWTH;
                return state;
            } else {
                state = VegetablePlanterState.START_STATE;
                return state;
            }
        } else {
            state = VegetablePlanterState.PLANTED_SEED;
            return state;
        }
    }

    /**
     * This method takes the player's input and sets the state of the game accordingly
     * @param input string player's choice
     */
    @Override
    public String inputOnPlantedPlanter(String input) {
        if(input.equals("1")) {
            state = VegetablePlanterState.LOOK_AT_PLANTS;
        } else {
            state = VegetablePlanterState.START_STATE;
        }
        return state;
    }

    /**
     * This method controls what is displayed when the player looks at the planter. If they have a seed they can plant it,
     * if they have already planted the seed they see plants, if they neither have a seed or have planted anything they just see the
     * description of the planter
     * @return String description and set of choices for the player
     */
    @Override
    public String examinePlanter() {
        if (seedState.equals("HAVE_ONION_SEED") && !plantState.equals("PLANT_EXISTS")) {
            return "The row of wooden planters line the north and east walls of the room. The sides of the planters are " +
                    "decorated with pictures of vegetables. They are filled with rich soil. \n" +
                    "Do you:\n" +
                    "1) Plant onion seed\n" +
                    "3) Return to room";
        } else if (plantState.equals("PLANT_EXISTS")) {
            return "There are small plant shoots in the planter boxes. \n" +
                    "Do you:\n" +
                    "1) Examine plants \n" +
                    "2) Return to room";
        }
        return "The row of wooden planters line the north and east walls of the room. The sides of the planters are " +
                "decorated with pictures of vegetables. They are filled with rich soil. But there is nothing growing in them.\n" +
                "Do you:\n" +
                "1) Return to room";
    }

    /**
     * This method controls what is displayed when the player looks at the planter after having planted a seed
     * @return String description and set of choices for the player
     */
    @Override
    public String examinePlantedPlanter() {
        return "The small plants in the planter boxes look tiny and sad. Perhaps some fertilizer would help. \nDo you:\n" +
                "1) Examine plants more closely \n" +
                "2) Return to room";
    }

    /**
     * This method controls what is displayed when the player looks at the plants and gives them choices based on whether or not
     * they have already picked up fertilizer from the table
     * @return String description and set of choices for the player
     */
    @Override
    public String examinePlants() {
        if (!fertilizerState.equals("NO_FERTILIZER")) {
            return "The plants are just tiny little shoots. You have a bag of fertilizer.\n" +
                    "Do you: \n" +
                    "1) Fertilize plants \n" +
                    "2) Return to room";
        } else return "The plants are just tiny little shoots. They could use some fertilizer.\n" +
                "Do you: \n" +
                "1) Return to room";
    }

    /**
     * This method displays the growth of the plant based on the choice of fertilizer
     * @return String description of plant growth and option to exit the game
     */
    @Override
    public String examineGrowth() {
        return VegetablePlanter.growth + "\nYou grew a plant! Thanks for playing!\n" +
                "1) Exit";
    }

}
