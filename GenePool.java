import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Random;

/**
 * This class resembels a database file for all
 * possible organisms in the game. In the future, it 
 * may have a user input constructor to allow user
 * defined animals or plants.
 * 
 * @author GD
 * @version 2014.03.13
 */
public class GenePool
{
    private int maxHealthPoints;
    private int currentHealthPoints;
    private int maxPopPerPoint;
    private int breedingCycle;

    private double hitByFire;
    
    private boolean isAlive;

    private String name;
    private String id;
    
    private Random rnd;

    private ArrayList<String> canEat;
    private HashMap<String, GenePool> organismCollection;

    /**
     * Constructor for objects of class GenePool
     */
    public GenePool()
    {
        maxHealthPoints = 0;
        currentHealthPoints = 0;
        maxPopPerPoint = 0;
        breedingCycle = 0;
        hitByFire = 0.0;
        isAlive = false;
        name = new String();
        id = new String();
        rnd = new Random();
        canEat = new ArrayList<String>();
        organismCollection = new HashMap<String, GenePool>();
    }

    // Each method sets the GenePool's variables to the desierd
    // animal settings and return it as an object.
    /**
     * Grass code for Organism objects.
     * 
     * @return The GenePool instance for grass,
     * requierd by objects of class Organism.
     */
    public GenePool grass()
    {
        setMaxHp(-1);
        setCurrentHealth();
        setMaxPopPerPoint(10);
        setBreedingCycle(2);
        setChanceHitByFire(0.75);
        setLifeStatus(false);
        setName("Grass");
        generateID();
        canEat.clear();
        return this;
    }

    /**
     * Tree code for Organism objects.
     * 
     * @return The GenePool instance for trees,
     * requierd by objects of class Organism.
     */
    public GenePool tree()
    {
        setMaxHp(-1);
        setCurrentHealth();
        setMaxPopPerPoint(10);
        setBreedingCycle(5);
        setChanceHitByFire(0.6);
        setLifeStatus(false);
        setName("Tree");
        generateID();
        canEat.clear();
        canEat.add(new GenePool().grass().getID());
        return this;
    }

    /**
     * Deer code for Organism objects.
     * 
     * @return The GenePool instance for deers,
     * requierd by objects of class Organism.
     */
    public GenePool deer()
    {
        setMaxHp(8);
        setCurrentHealth();
        setMaxPopPerPoint(-1);
        setBreedingCycle(4);
        setChanceHitByFire(0.0);
        setLifeStatus(true);
        setName("Deer");
        generateID();
        canEat.clear();
        canEat.add(new GenePool().grass().getID());
        canEat.add(new GenePool().tree().getID());
        return this;
    }

    // Usefule methods
    /**
     * This method runs all the organisms codes avilable in the class
     * and collect them in a HashMap with their unique id number to allow
     * random organism creation via Organism.
     */
    private void updateGeneCollection()
    {
        organismCollection.put(new GenePool().grass().getID(), new GenePool().grass());
        organismCollection.put(new GenePool().tree().getID(), new GenePool().tree());
        organismCollection.put(new GenePool().deer().getID(), new GenePool().deer());
    }

    /**
     * Returns a List collection of keys 
     * for the geneCollection avilable in this gene pool object.
     * 
     * @return a List collection of all the uniqe ids of the
     * organisms that are avilable in this gene pool object.
     */
    public GenePool[] getAllAvilableOrganisms()
    {
        updateGeneCollection();
        GenePool[] array = organismCollection.values()
                           .toArray(new GenePool[organismCollection.size()]);
        return array;
    }
    
    /**
     * Generate a random organism code and return it.
     * 
     * @return A new random GenePool object for random organism
     * reation.
     */
    public GenePool getRandomCode()
    {
        return getAllAvilableOrganisms()[rnd.nextInt(getAllAvilableOrganisms().length)];
    }

    // Setters/Getters methods
    /**
     * Set the max health points of the desired organism.
     * 
     * @param hp The max health points of the organism.
     */
    public void setMaxHp(int hp)
    {
        maxHealthPoints = hp;
    }

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
    public void setCurrentHealth()
    {
        currentHealthPoints = maxHealthPoints;
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
     * Define the maximum number of the same organism allowed
     * per point on the map/grid.
     * 
     * @param maxPerPoint The cap allowed per point on the
     * map/grid.
     */
    public void setMaxPopPerPoint(int maxPerPoint)
    {
        maxPopPerPoint = maxPerPoint;
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
     * Set the breeding cycle. Or, how often does the organism
     * reproduce.
     * 
     * @param cycles The amount of cycles before the organism
     * can reproduce.
     */
    public void setBreedingCycle(int cycles)
    {
        breedingCycle = cycles;
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
     * Set the organism's chance of getting hit by fire.
     * 
     * @param chance The chance to get hit by fire in percentage.
     */
    public void setChanceHitByFire(double chance)
    {
        hitByFire = chance;
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
     * Set the organism's isAlive boolean identifier.
     * 
     * @param isAlive Whether or not the organism is living.
     * True if it is a living animal, False if it's a dead or a plant.
     */
    public  void setLifeStatus(boolean isAlive)
    {
        this.isAlive = isAlive;
    }
    
    /**
     * Return the organism's isAlive boolean identifier.
     * 
     * @return True if the organism is a living Animal. False
     * if it's dead or a plant.
     */
    public boolean getLifeStatus()
    {
        return isAlive;
    }

    /**
     * Set the name of the organism, e.g. deer, grass, tree, etc.
     * 
     * @param name The name of the organism.
     */
    public void setName(String name)
    {
        this.name = name;
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
     * Generate a unique ID for the organism using it's unchanging
     * fields:
     * maxHealthPoints + ":" + breedingCycle + two first letters
     * of name + hitByFire.
     * And set it as its ID
     */
    public void generateID()
    {
        id = "" + maxHealthPoints + ":"  + breedingCycle + 
        name.substring(0,2).toUpperCase() + hitByFire;
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