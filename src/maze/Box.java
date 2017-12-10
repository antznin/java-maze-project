package maze;
import java.util.ArrayList;

import dijkstra.VertexInterface;

/** <h1> Box class </h1>
 * <p>
 * 
 * This class describes a Box and implements {@link dijkstra.VertexInterface}.
 * <p>
 * A Box is represented with its coordinates, its label, and its neighbourList. It also has a reference on the Maze.
 * 
 * @author Antonin Godard
 * @author Sylvain Rager
 *
 */

public abstract class Box
		implements VertexInterface {

	private int x ;
	private int y ;
	private String label = null ;
	private Maze maze ;
	private ArrayList<Box> neighbourList = new ArrayList<Box>() ;
	
	public Box (String label, int x, int y, Maze maze) {
		
		this.label = label ;
		this.x = x ;
		this.y = y ;
		this.maze = maze ;
		
	}
	
	public ArrayList<VertexInterface> generateNeighbors() {
		return maze.generateNeighbours(this) ;
		
	}
	
	public boolean isWalkable() {
		return true ;
	}
	
	public boolean isArrival() {
		return false ;
	}
	
	public boolean isDeparture() {
		return false ;
	}
	
	public ArrayList<Box> getNeighbourList() {
		return neighbourList;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public String getLabel() {
		return label;
	}
	
	public String toString() {
		return "Label: " + label + ", x: " + x + ", y: " + y;
	}
	
}