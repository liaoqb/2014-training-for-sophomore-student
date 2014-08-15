  // <Copyright liaoqb>  [Copyright 2014.08.04]
/*This is the comment line
 *I don't like it very much
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * */


import info.gridworld.actor.Bug;


  // the length can plus two once time
public class CircleBug extends Bug {
  private int steps;
  private int sideLength;

    // constructor function
    public CircleBug(int length) {
      steps = 0;
      sideLength = length;
    }

      // move twrice once time
    public void act() {
      if (steps < sideLength && canMove()) {
        move();
        steps++;
      } else {
        turn();
        steps = 0;
      }
    }
}
