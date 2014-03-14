import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Organism class hold the structure for every organism
 * in the Ecosystem.
 * 
 * @author Gil Dekel     
 * @version 2014.03.13
 */
public class Organism
{
    private int maxHealthPoints;
    private int currentHealthPoints;
    private int maxPopPerPoint;
    private int breedingCycle;
    private int currentCycle;

    private double hitByFire;

    private boolean isAlive;

    private String name;
    private String id;

    private Random rnd = new Random();

    private ArrayList<String> canEat;
    
    // Organism objects should not be instantiated with
    // the void constructer unless used as a temporary instanse,
    public Organism()
    {
        maxHealthPoints = 0;
        currentHealthPoints = 0;
        maxPopPerPoint = 0;
        breedingCycle = 0;
        currentCycle = 0;
        hitByFire = 0;
        isAlive = false;
        name = new String();
        id = new String();
        canEat = new ArrayList<String>();
    }

    /**
     * Organisms are constructed with the information passed from
     * GenePool. GenePool objects hold all the variables requierd
     * to create the different animals or plants for the Ecosystem.
     * 
     * @param organismCode The object containing all the information
     * requierd to generate the wanted animal/plant.
     */
    public Organism(GenePool organismCode)
    {
        maxHealthPoints = organismCode.getMaxHp();
        currentHealthPoints = maxHealthPoints;
        maxPopPerPoint = organismCode.getMaxPopPerPoint();
        breedingCycle = organismCode.getBreedingCycle();
        currentCycle = rnd.nextInt(breedingCycle)+1;
        hitByFire = organismCode.getChanceHitByFire();
        isAlive = organismCode.getLifeStatus();
        name = organismCode.getName();
        id = organismCode.getID();
        canEat = organismCode.getCanEat();
    }

    // Useful methods

    /**
     * Simulates birth. The organism creates another organism
     * such as himself only if its in prime condition.
     * 
     * @return A duplication of itself if in prime condition.
     * Otherwise return null;
     */
    public Organism giveBirth()
    {
        if(currentHealthPoints == maxHealthPoints)
            return this;
        else
            return null;
    }

    /**
     * Generate a RANDOM organism.
     * 
     * @return A new random organism.
     */
    public Organism newRandomOrganism()
    {
        return new Organism(new GenePool().getRandomCode());
    }

    // Setters/Getters methods
    /**
     * Get the max health points of the desired organism.
     * 
     * @return An int holding the max health points of the organism.
     */
    public int getMaxHp()
    {
        return maxHealthPoints;
    }

    /**
     * Set the current health point to equal the max
     * health point, since all new organisms begins
     * with full health.
     */
    public void setCurrentHealth(int currentHP)
    {
        currentHealthPoints = currentHP;
    }

    /**
     * get the current health points of the organism.
     * 
     * @return An int holding the current health points 
     * of the organism.
     */
    public int getCurrentHealth()
    {
        return currentHealthPoints;
    }

    /**
     * Get the maximum number of the same organism allowed
     * per point on the map/grid.
     * 
     * @retun An int holding the maximum number allowed of the
     * organism per point on the map/grid.
     */
    public int getMaxPopPerPoint()
    {
        return maxPopPerPoint;
    }

    /**
     * Get the breeding cycle. Or, how often does the organism
     * reproduce.
     * 
     * @return An int number holding the number of cycles requierd
     * to pass before an organism can reproduce.
     */
    public int getBreedingCycle()
    {
        return breedingCycle;
    }

    /**
     * Get the organism's chance of getting hit by fire.
     * 
     * @return A double containing the organism's chance 
     * to get hit by fire (decimal point percentage).
     */
    public double getChanceHitByFire()
    {
        return hitByFire;
    }

    /**
     * Get the name of the organism, e.g. deer, grass, tree, etc.
     * 
     * @return The name of the organism as String.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Get the unique Id that was generated for the organism.
     */
    public String getID()
    {
        return id;
    }

    /**
     * Get the collection containing the food the organism
     * can consume.
     * 
     * @return An ArrayList containing id Strings of the
     * organisms this organism can consume.
     */
    public ArrayList<String> getCanEat()
    {
        return canEat;
    }
}