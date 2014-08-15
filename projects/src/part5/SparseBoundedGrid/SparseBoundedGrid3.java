  // <Copyright liaoqb>  [Copyright 2014.08.06]
  // This is the sparseboundedgrid, I don't know how to do

import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/*
 *This is the class that call for boundedgrid3, I dont't like it
 *Do you think is it very boring?
 *The explain is very dull
 * */
public class SparseBoundedGrid3<E> extends AbstractGrid<E> {
  private Map<Location, E> occupantArray;
  private int row;
  private int col;

    // initalize function
  public SparseBoundedGrid3(int r, int c) {
    if (r <= 0 || c <= 0) {
      throw new IllegalArgumentException(r <= 0 ? "rows <= 0" : "cos <= 0");
    }

    row = r;
    col = c;
    occupantArray = new HashMap<Location, E>();
  }

    // get number rows
  public int getNumRows() {
    return row;
  }

    // get number column
  public int getNumCols() {
    return col;
  }

    // is valid
  public boolean isValid(Location location) {
    return (location.getRow() >= 0 && location.getRow() < row &&
      location.getCol() >= 0 && location.getCol() < col);
  }

  public ArrayList<Location> getOccupiedLocations() {
      // This is the list array
    ArrayList<Location> locations = new ArrayList<Location>();

    for (Location location : occupantArray.keySet()) {
      locations.add(location);
    }

    return locations;
  }

    // get function
  public E get(Location location) {
    if (location == null) {
      throw new NullPointerException("loc == null");
    } else {
      return occupantArray.get(location);
    }
  }

    // put function
  public E put(Location location, E object) {
    if (location == null) {
        throw new NullPointerException("loc == null");
    }

    if (object == null) {
      throw new NullPointerException("obj == null");
    }

    return occupantArray.put(location, object);    
  }

    // remove function
  public E remove(Location location) {
    if (location == null) {
      throw new NullPointerException("loc == null");
    }

    return occupantArray.remove(location);
  }
}
