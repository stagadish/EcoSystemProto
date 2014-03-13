import java.util.HashMap;
import java.util.ArrayList;
import java.awt.Point;
import java.util.Random;

/**
 * Write a description of class Map here.
 * 
 * @author Gil Dekel
 * @version 2014.3.12
 */
public class Map
{
    private int x;
    private int y;
    private HashMap<Point, ArrayList<Organism>> grid;
    private Random rnd;

    /**
     * Constructor for objects of class Map
     */
    public Map(int x, int y)
    {
        this.x = x;
        this.y = y;
        rnd = new Random();
        grid = new HashMap<Point, ArrayList<Organism>>();
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void generateGrid()
    {
        int totalOrganisms = 0;
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                Point p = new Point(i,j);
                grid.put(p, new ArrayList<Organism>());
                if(rnd.nextInt(x+1) < x/2) {
                    for(int k=0; k <= rnd.nextInt(4); k++)
                        grid.get(p).add(new Organism());
                    totalOrganisms++;
                }
                Double tempX = p.getX();
                Double tempY = p.getY();
                System.out.print(tempX.intValue() +","+ tempY.intValue() +"-"+ 
                    grid.get(p).size()+ "\t");

            }
            System.out.println();

        }
        System.out.println("Total number of organisms created: " + totalOrganisms + ".");
    }
}
