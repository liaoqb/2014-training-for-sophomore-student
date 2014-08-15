/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2002-2006 College Entrance Examination Board 
 * (http://www.collegeboard.com).
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Alyce Brady
 * @author APCS Development Committee
 * @author Cay Horstmann
 */

  // <Copyright liaoqb>  [Copyright liaoqb]
  // This is the sparseboundedgrid2, I don't know how to do
import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

public class SparseBoundedGrid2<E> extends AbstractGrid<E> {
  private ArrayList<LinkedList> rowArray;
  private int row;
  private int col;

  public SparseBoundedGrid2(int r, int c) {
    if (r <= 0 || c <= 0) {
      throw new IllegalArgumentException(r <= 0 ? "rows <= 0" : "cos <= 0");
    }

    row = r;
    col = c;
    rowArray = new ArrayList<LinkedList>();

    for (int i = 0; i < row; ++i) {
      rowArray.add(new LinkedList<OccupantInCol>());
    }
  }

  public int getNumRows() {
    return row;
  }

  public int getNumCols() {
    return col;
  }

  public boolean isValid(Location location) {
    return (location.getRow() >= 0 && location.getRow() < row &&
      location.getCol() >= 0 && location.getCol() < col);
  }

  public ArrayList<Location> getOccupiedLocations() {
    ArrayList<Location> locations = new ArrayList<Location>();

    for (int i = 0; i < this.row; ++i) {
      /*
      for (int j = 0; j < rowArray.get(i).size(); ++j) {
        locations.add(new Location(i, occupant.getCol()));
      }
    */

      if (rowArray.get(i) != null) {
        Iterator<OccupantInCol> iter = rowArray.get(i).iterator();

        while (iter.hasNext()) {
          locations.add(new Location(i, iter.next().getCol()));
        }
      }

      /*
      for (OccupantInCol temp : rowArray.get(i)) {
        locations.add(new Location(i, temp.getCol()));
      }
      */
    }

    return locations;
  }

  public E get(Location location) {
    if (!this.isValid(location)) {
      throw new IllegalArgumentException("Location " + location + " is not valid");
    } else if (rowArray.get(location.getRow()) == null) {
      return null;
    } else {
        // maybe complex, take care
      
      /*
      for (int i = 0; i < rowArray.get(location.getRow()).size(); ++i) {
        if (rowArray.get(location.getRow()).get(i).getCol() == location.getCol()) {
          return (E)rowArray.get(location.getRow()).get(i).getOccupant();
        }
      }
      */

      if (rowArray.get(location.getRow()) != null) {
        Iterator<OccupantInCol> iter = rowArray.get(location.getRow()).iterator();

        while (iter.hasNext()) {
            // This is very important
          OccupantInCol occupant = iter.next();
          if (occupant.getCol() == location.getCol()) {
            return (E)occupant.getOccupant();
          }
        }
      }

      return null;
    }
  }

  public E put(Location location, E object) {
      // this is the put code
    if (!this.isValid(location)) {
      throw new IllegalArgumentException("Location " + location + " is not valid");
    } else {
      if (object == null) {
        throw new NullPointerException("obj == null");
      } else {
        E oldOccupant = this.remove(location);

        rowArray.get(location.getRow()).add(new OccupantInCol(object, location.getCol()));

        return oldOccupant;
      }
    }
  }

  public E remove(Location location) {
    if (!this.isValid(location)) {
      throw new IllegalArgumentException("Location " + location + " is not valid");
    } else {
      E removeObject = this.get(location);

        // take care
      if (removeObject != null) {
        /*
        for (int i = 0; i < rowArray.get(location.getRow()).size(); ++i) {
          if (rowArray.get(location.getRow()).get(i).getCol() == location.getCol()) {
            rowArray.get(location.getRow()).remove(i);
            break;
          }
        }
        */

        Iterator<OccupantInCol> iter = rowArray.get(location.getRow()).iterator();

        while (iter.hasNext()) {
          if (iter.next().getCol() == location.getCol()) {
            iter.remove();
            break;
          }
        }
      }

      return removeObject;
    }
  }
}


