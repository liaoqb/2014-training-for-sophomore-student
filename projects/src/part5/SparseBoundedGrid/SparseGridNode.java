  // <Copyright liaoqb>  [Copyright 2014.08.06]
  // This is a class that is for the data struct
public class SparseGridNode {
  private Object occupant;
  private int col;
  private SparseGridNode next;

    // This is the initaize function
  public SparseGridNode(Object o, int c, SparseGridNode n) {
    occupant = o;
    col = c;
    next = n;
  }

    // get it
  public void setOccupant(Object o) {
    occupant = o;
  }

    // This is not good, take care
  public void setCol(int c) {
    col = c;
  }

    // set it
  public void setNext(SparseGridNode n) {
    next = n;
  }

    // get it
  public Object getOccupant() {
    return occupant;
  }

    // set it
  public int getCol() {
    return col;
  }

    // get it
  public SparseGridNode getNext() {
    return next;
  }
}
