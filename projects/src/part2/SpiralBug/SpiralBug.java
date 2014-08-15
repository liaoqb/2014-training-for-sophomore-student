  // <Copyright liaoqb>  [Copyright 2014.08.04]

import info.gridworld.actor.Bug;

public class SpiralBug extends Bug {
  private int steps;
  private int sideLength;

  public SpiralBug(int length) {
      // copy function
    steps = 0;
    sideLength = length;
  }

  public void act() {
    if (steps < sideLength && canMove()) {
      move();
      steps++;
    } else {
        // when turning, sideLength increments
      sideLength += 1;
        // turn twice, which is change another direction
      turn();
      turn();

        // reset steps
      steps = 0;
    }
  }
}
