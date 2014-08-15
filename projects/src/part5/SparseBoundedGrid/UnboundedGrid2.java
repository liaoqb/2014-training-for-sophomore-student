  // <Copyright liaoqb>  [Copyright 2014.08.06]
  // This is the unbounded2, I don't know how to do

import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList;

/*
 * This is the program extends abstractgrid
 * But it has some bug that can't be removed
 * It is very strange
 * isn't it?
 * I don't like this very much
 * This is not good
 * Is it very bored?
 * */
public class UnboundedGrid2<E> extends AbstractGrid<E> {
  private Object[][] unboundedArray;
  private int capacity;

    // initailize
  public UnboundedGrid2() {
    capacity = 16;
    unboundedArray = new Object[16][16];
  }

  public int getNumRows() {
    return -1;
  }

  public int getNumCols() {
    return -1;
  }

    // return the valid value
  public boolean isValid(Location location) {
    if (location.getRow() >= 0 && location.getCol() >= 0) {
      return true;
    } else {
      return false;
    }
  }

    // get the location that had been occupied
  public ArrayList<Location> getOccupiedLocations() {
    ArrayList<Location> locations = new ArrayList<Location>();

    for (int i = 0; i < capacity; ++i) {
      for (int j = 0; j < capacity; ++j) {
        Location location = new Location(i, j);

          // This will cause a severe problem
        if (this.get(location) != null) {
          locations.add(location);
        }
      }
    }

    return locations;
  }

    // get the location in the grid
  public E get(Location location) {
    if (!this.isValid(location)) {
      throw new IllegalArgumentException("Location " + location + " is not valid");
    } else {
      if (location.getRow() < capacity && location.getCol() < capacity) {
        return (E)unboundedArray[location.getRow()][location.getCol()];
      } else {
        return null;
      }
    }
  }

    // put the location in the grid
  public E put(Location location, E object) {
    if (location == null) {
      throw new NullPointerException("obj == null");
    }

    if (object == null) {
      throw new NullPointerException("loc == null");
    }

    if (!this.isValid(location)) {
      return null;
    } else {
      if (location.getRow() < capacity && location.getCol() < capacity) {
        E oldOccupant = this.get(location);
        unboundedArray[location.getRow()][location.getCol()] = object;

        return oldOccupant;
      } else {
        int tempCapacity = capacity;
        Object[][] newArray;

        while (location.getRow() >= capacity || location.getCol() >= capacity) {
          capacity *= 2;
        }

        newArray = new Object[capacity][capacity];

        for (int i = 0; i < tempCapacity; ++i) {
          for (int j = 0; j < tempCapacity; ++j) {
            newArray[i][j] = unboundedArray[i][j];
          }
        }

        unboundedArray = newArray;
        
        unboundedArray[location.getRow()][location.getCol()] = object;

        return null;
      }
    }
  }

    // remove the location on the grid
  public E remove(Location location) {
    if (!this.isValid(location)) {
      throw new IllegalArgumentException("Location " + location + " is not valid");
    } else if (location.getRow() < capacity && location.getCol() < capacity) {
      E removeOccupant = this.get(location);
      unboundedArray[location.getRow()][location.getCol()] = null;

      return removeOccupant;
    } else {
      return null;
    }
  }
}
