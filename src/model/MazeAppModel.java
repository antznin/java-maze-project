package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import dijkstra.VertexInterface;
import dijkstra.Dijkstra;
import dijkstra.Previous;
import maze.Maze;

public class MazeAppModel extends Observable {

	private String										 filename;
	private Maze                       maze;
	private VertexInterface            departure;
	private VertexInterface            arrival;
	private Previous                   previous;
	private ArrayList<VertexInterface> shortest;
	private ArrayList<VertexInterface> boxList;
	private Boolean                    modified      = false;

	public MazeAppModel() {
		maze = new Maze(Maze.emptyMaze(10));
		departure = maze.getDeparture();
		arrival = maze.getArrival();
		boxList = maze.getVertexes();
		if (departure == null || arrival == null) {
			return;
		}
		previous = (Previous) Dijkstra.dijkstra(maze, departure);
		shortest = previous.getShortestPathTo(arrival);
	}

	public void loadMaze(String filename) {
		this.filename = new String(filename);
		maze = new Maze(this.filename);
		modified = true;
		setChanged();
		notifyObservers(MazeAppModelMessage.MazeRenewal);
	}

	public Maze getMaze() {
		return maze;
	}

	public String getFilename() {
		return filename;
	}

	public boolean isModified() {
		return modified;
	}

	public void saveToFile() {
		maze.saveToTextFile(filename);
	}

	public void saveToFile(String filename) {
		this.filename = new String(filename);
		maze.saveToTextFile(this.filename);
		modified = true;
		setChanged();
		notifyObservers(MazeAppModelMessage.FileChange);
	}
}
