  // <Copyright liaoqb>  [Copyright 2014.08.04]

import info.gridworld.actor.Bug;

public class DancingBug extends Bug {
  private int[] dancingArray;
    // array counter
  private int count;

  public DancingBug(int[] dArray) {
    dancingArray = new int[dArray.length];

    System.arraycopy(dArray, 0, dancingArray, 0, dancingArray.length);

    count = 0;
  }

  public void act() {
    if (canMove()) {
      move();
    } else {
      count++;

        // loop for the array
      count %= dancingArray.length;

        // turn for the array count
      for (int i = 0; i < dancingArray[count]; ++i) {
        turn();
      }
    }
  }
}
