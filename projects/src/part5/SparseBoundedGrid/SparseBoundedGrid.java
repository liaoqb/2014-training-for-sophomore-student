  // <Copyright liaoqb>  [Copyright liaoqb]
  // This is the sparseboundedgrid, I don't know how to do
import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList;

public class SparseBoundedGrid<E> extends AbstractGrid<E> {
  private SparseGridNode[] rowArray;
  private int row;
  private int col;

  public SparseBoundedGrid(int r, int c) {
    if (r <= 0 || c <= 0) {
      throw new IllegalArgumentException(r <= 0 ? "rows <= 0" : "cos <= 0");
    }

    row = r;
    col = c;
    rowArray = new SparseGridNode[r];
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
      // This is the list array
    ArrayList<Location> locations = new ArrayList<Location>();

    for (int i = 0; i < this.row; ++i) {
      for (SparseGridNode node = rowArray[i]; node != null; node = node.getNext()) {
        locations.add(new Location(i, node.getCol()));
      }
    }

    return locations;
  }

  public E get(Location location) {
    if (!this.isValid(location)) {
      throw new IllegalArgumentException("Location " + location + " is not valid");
    } else {
      for (SparseGridNode node = rowArray[location.getRow()]; node != null; node = node.getNext()) {
        if (node.getCol() == location.getCol()) {
          return (E)(node.getOccupant());
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

        SparseGridNode node = rowArray[location.getRow()];

          // find the last position, take care
        if (node == null) {
          rowArray[location.getRow()] = new SparseGridNode(object, location.getCol(), null);
        } else {
          while (node.getNext() != null) {
            node = node.getNext();
          }

          node.setNext(new SparseGridNode(object, location.getCol(), null));
        }

        return oldOccupant;
      }
    }
  }
    // take care
  public E remove(Location location) {
    if (!this.isValid(location)) {
      throw new IllegalArgumentException("Location " + location + " is not valid");
    } else {

        // This is very important
      E removeObject = this.get(location);

      SparseGridNode node = rowArray[location.getRow()];

      if (node != null) {
          // the first one
        if (node.getCol() == location.getCol()) {
          rowArray[location.getRow()] = node.getNext();
        } else {
          SparseGridNode tempNode = node.getNext();

          while (tempNode != null) {
            if (tempNode.getCol() == location.getCol()) {
              node.setNext(tempNode.getNext());
              break;
            } else {
              tempNode = tempNode.getNext();
              node = node.getNext();
            }
          }
        }
      }

      return removeObject;
    }
  }

/*
*public E remove(Location loc)
*{
*if (!isValid(loc))
*throw new IllegalArgumentException("Location " + loc
*+ " is not valid");
* Remove the object from the grid.
*E obj = get(loc);
*if (obj == null) return null; //if not found, return null
*SparseGridNode p = rowArray[loc.getRow()];
*if(p != null)
*{
*if(p.getCol() == loc.getCol()) //check the first node
*rowArray[loc.getRow()] = p.getNext();
*else
*{
*q searches for the occupant in the loc.getCol()
*p stays behind to remove the occupant, if found
*SparseGridNode q = p.getNext();
*while(q!= null && q.getCol() != loc.getCol())
*{
*p = p.getNext();
*q = q.getNext();
*}
*if found, remove the occupant at loc.getCol()
*if(q != null)
*p.setNext(q.getNext());
*}
*}
*return obj;
*}
*/
}
