import java.awt.Point;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author MW
 * @author GD
 * @version 3.12.14
 */
public class Map {
    private int gridWidth = 0;
    private int gridHeight = 0;
    private int maxOrganismsAllowed = 0;
    private Random rnd = new Random();
    private HashMap<Point, ArrayList<Organism>> coordinateMap;
    // A test variable. Keeps the points in a sorted collection.
    private ArrayList<Point> points;

    /**
     * Default constructor for the 12x12 Map Grid
     */
    public Map(){
        gridWidth = 12;
        gridHeight = 12;
        coordinateMap = new HashMap<Point, ArrayList<Organism>>();
        points = new ArrayList<Point>();
        generateGrid();
        maxOrganismsAllowed = generateMaxOrganismsAtStart();
    }

    /**
     * Custom size Map Grid Constructor
     * @param x is the user defined width
     * @param y is the user defined height
     */
    public Map(int x, int y){
        gridWidth = x;
        gridHeight = y;
        coordinateMap = new HashMap<Point, ArrayList<Organism>>();
        points = new ArrayList<Point>();
        generateGrid();
        maxOrganismsAllowed = generateMaxOrganismsAtStart();
    }

    /**
     * Generates a HashMap grid with Points to hold x,y positions
     * and Organism ArrayLists to hold all the organisms per point.
     * private method. Should be generated only once per Map instance.
     */
    private void generateGrid() {
        for(int i = 0; i < gridHeight; i++) {
            for(int j = 0; j < gridWidth; j++) {
                Point p = new Point(j,i);
                coordinateMap.put(p, new ArrayList<Organism>());
                points.add(p);
            }
        }
    }

    // A test print to follow information about the grid.
    /**
     * Prints out a grid with it's current state in the
     * following format:
     * x,y-totalOrganismsPerPoint.
     */
    public void printGrid()
    {   
        int organismCounter = 0;
        for(Point p : points) {
            Double tempX = p.getX();
            Double tempY = p.getY();

            if(!coordinateMap.get(p).isEmpty())
                organismCounter += coordinateMap.get(p).size();
            System.out.print(tempX.intValue() +","+ 
                tempY.intValue() +"-"+
                coordinateMap.get(p).size()+ "\t");
            if(tempX.intValue() == gridWidth-1)
                System.out.println();
        }
        if(organismCounter == maxOrganismsAllowed) {
            System.out.println("\n" + "Test was successful. " +
                organismCounter + " RANDOM organisms were created " +
                "at RANDOM points on the grid!");
        }
        else {
            System.out.println("\n" + "Test failed. The maximum number of organisms " +
                               "allowed on this grid is " + maxOrganismsAllowed +
                               " while " + organismCounter + " organisms were created.");
        }
    }

    //Useful methods
    /**
     * Generate the maximum number of organisms allowed 
     * upon initialization of the ecosystem. The number should be
     * reasonable.
     * 
     * @return A random number between gridArea/4 and gridArea/2 + a random
     * number with the range of gridArea/8
     */
    public int generateMaxOrganismsAtStart()
    {
        return rnd.nextInt(((gridWidth*gridHeight)/2) - 
            (gridWidth*gridHeight)/4) + (gridWidth*gridHeight)/4 +
        (gridWidth*gridHeight)/8;

    }

    /**
     * Pull one random organism and place it in one random point.
     */
    public void randomOrganismAtRandomPoint()
    {
        Point rndP = points.get(rnd.nextInt(points.size()));
        coordinateMap.get(rndP).add(new Organism().newRandomOrganism());
    }

    // Setters/Getters methods    
    /**
     * Returns the grid.
     * 
     * @return The coordinate map as a HashMap.
     */
    public HashMap<Point, ArrayList<Organism>> getCoordinateMap()
    {
        return coordinateMap;
    }

    /**
     * Get the grid's width.
     * 
     * @return The grid's width.
     */
    public int getWidth()
    {
        return gridWidth;
    }

    /**
     * Get the grid's height.
     * 
     * @return The grid's height.
     */
    public int getHeight()
    {
        return gridHeight;
    }
    
    /**
     * Get the maximum number of organisms allowed
     * on the grid.
     * 
     * @return An int number holding the maximum
     * number of organisms allowed on the this map instance.
     */
    public int getMaxOrganismsAllowed()
    {
        return maxOrganismsAllowed;
    }
}