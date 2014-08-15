  // <Copyright liaoqb>  [Copyright 2014.08.06]
  // This is a class for data struct
public class OccupantInCol {
  private Object occupant;
  private int col;

    // This is the initalize function
  public OccupantInCol(Object o, int c) {
    occupant = o;
    col = c;
  }
  
    // set it
  public void setOccupant(Object o) {
    occupant = o;
  }
  
    // get it
  public void setCol(int c) {
    col = c;
  }

    // set it
  public Object getOccupant() {
    return occupant;
  }


    // get it
  public int getCol() {
    return col;
  }
}
