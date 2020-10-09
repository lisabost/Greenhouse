package planters;

public interface FruitPlanterState {


    /**
     * sets state to the starting state
     */
    String START_STATE = "START";

    /**
     * Sets state to the player is looking at the planter
     */
    String LOOK_AT_PLANTER = "LOOK_AT_PLANTER";

    /**
     * Sets state to the player is looking at the plants
     */
    String LOOK_AT_PLANTS = "LOOK_AT_PLANTS";

    /**
     * Sets state to plants exist
     */
    String PLANT_EXISTS = "PLANT_EXISTS";

    /**
     * Sets state to the player has planted seeds
     */
    String PLANTED_SEED = "PLANTED_SEED";

    /**
     * Sets state to the player has not planted seeds
     * Default state at start of the game
     */
    String NOT_PLANTED_SEED = "NOT_PLANTED_SEED";

    /**
     * Sets state to the player has applied fertilizer to the plants
     */
    String PLANT_GROWTH = "PLANT_GROWTH";

    /**
     * Sets tomatoSeedState to the player does not have a tomato seed
     * Default state at start of the game
     */
    String NO_TOMATO_SEED = "NO_TOMATO_SEED";

    /**
     * Sets fertilizerState to the player does not have fertilizer
     * Default state at the start of the game
     */
    String NO_FERTILIZER = "NO_FERTILIZER";

}
