import java.util.Random;
import java.util.Set;
import java.awt.Point;

/**
 * Mother Nature (or MN) is the algorithm in charge
 * of enforcing the rules of reproduction, movement
 * consumption, damage and death of all organisms
 * over the Map.
 * 
 * @author MW
 * @authpor GD
 */

public class MotherNature {
    // Hold a map object. The grid is generated via the
    // Map constructor.
    private Map map = new Map();
    private Random rnd = new Random();
    
    public static void main(String[] args){
        MotherNature ecosystem = new MotherNature();
        ecosystem.initializeEcosystem();
    }
    
    public MotherNature()
    {
    }

    /**
     * Intialize a new EcoSystem. Fills a
     * new map with a reasonable ammount of random organisms
     * in random points on the grid.
     */
    public void initializeEcosystem()
    {
        for(int i=1; i <= map.getMaxOrganismsAllowed(); i++)
            map.randomOrganismAtRandomPoint();
        map.printGrid();
    }
}