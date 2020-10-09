package planters;

import plants.Seed;

/**
 * This class creates the rules for what a planter must have and do
 */
public abstract class Planter {
    private String description;

    public Planter(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void receiveSeedState(String onionSeedState) {
    }

    public void receivePlantState(String plantState) {
    }

    public void receiveFertilizerState(String fertilizerState) {

    }

    public void receiveSeed(Seed seed) {

    }
    public String inputOnPlanter(String input) {
        return null;
    }
    public String inputOnPlants(String input) {
        return null;
    }

    public String inputOnPlantedPlanter(String input) {
        return null;
    }

    public String examinePlanter() {
        return "This is a planter";
    }

    public String examinePlantedPlanter() {
        return "This planter now has plants growing in it.";
    }

    public String examinePlants() {
        return "This plants are so small and cute";
    }

    public String examineGrowth() {
        return "A plant is born";
    }
}
