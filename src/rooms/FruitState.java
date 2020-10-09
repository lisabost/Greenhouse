package rooms;

public interface FruitState {

    /**
     * Sets state to player is looking at the table
     */
    String LOOK_AT_TABLE = "LOOK_AT_TABLE";

    /**
     * Sets state to player is looking at the planter
     */
    String LOOK_AT_PLANTER = "LOOK_AT_PLANTER";

    /**
     * Sets state to player is looking at the note
     */
    String LOOK_AT_NOTE = "LOOK_AT_NOTE";

    /**
     * Sets state to player is looking at the boxes on the table
     */
    String LOOK_AT_BOXES = "LOOK_AT_BOXES";

    /**
     * Sets state to player is looking at the bags on the table
     */
    String LOOK_AT_BAGS = "LOOK_AT_BAGS";

    /**
     * Sets state to player is looking at the plants
     */
    String LOOK_AT_PLANTS = "LOOK_AT_PLANTS";

    /**
     * For tomatoSeedState
     * Sets state to player has a tomato seed
     */
    String HAVE_TOMATO_SEED = "HAVE_TOMATO_SEED";

    /**
     * For tomatoSeedState
     * Sets state to player does not have a tomato seed
     */
    String NO_TOMATO_SEED = "NO_TOMATO_SEED";

    /**
     * For fertilizerState
     * Sets state to player has fertilizer
     */
    String HAVE_FERTILIZER = "HAVE_FERTILIZER";

    /**
     * For fertilizerState
     * Sets state to player has instant grow fertilizer
     */
    String HAVE_INSTANT_FERTILIZER = "HAVE_INSTANT_FERTILIZER";

    /**
     * For fertilizer state
     * Sets state to player does not have fertilizer
     */
    String NO_FERTILIZER = "NO_FERTILIZER";

    /**
     * Sets state to player has planted a seed
     */
    String PLANTED_SEED = "PLANTED_SEED";

    /**
     * Sets state to player has not planted a seed
     * Default state
     */
    String NOT_PLANTED_SEED = "NOT_PLANTED_SEED";

    /**
     * Sets state to player has applied fertilizer to plants
     */
    String PLANT_GROWTH = "PLANT_GROWTH";
}
