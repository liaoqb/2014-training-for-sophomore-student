  // <Copyright liaoqb>  [Copyright 2014.08.04]

/*public class ZBug extends Bug {
  private int steps;
  private int sideLength;
  private int count;

  public ZBug(int length) {
      // count for the turn
    count = 0;
    steps = 0;
    sideLength = length;
      // init direction is 90 degrees
    this.setDirection(Location.EAST);
  }

  public void act() {
    if (canMove() && count != 3) {
      if (steps < sideLength) {
        move();
        steps++;
      } else {
        if (count == 0) {
          for (int i = 0; i < 3; ++i) {
            turn();
          }
        } else if (count == 1) {
          for (int i = 0; i < 5; ++i) {
            turn();
          }
        }

        count++;
        steps = 0;
      }
    }
  }
}*/

import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

public class ZBug extends Bug {
  private int steps;
  private int sideLength;
  private int count;

  public ZBug(int length) {
      // count for the turn
    count = 0;
    steps = 0;
    sideLength = length;
      // init direction is 90 degrees
    this.setDirection(Location.EAST);
  }

  public void act() {
    if (canMove() && count != 3) {
      if (steps < sideLength) {
        move();
        steps++;
      } else {
        if (count == 0) {
          for (int i = 0; i < 3; ++i) {
            turn();
          }
        } else if (count == 1) {
          for (int i = 0; i < 5; ++i) {
            turn();
          }
        }

        count++;
        steps = 0;
      }
    }
  }
}
