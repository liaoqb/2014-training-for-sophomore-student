  // <Copyright liaoqb>  [Copyright 2014.08.05]
/*
 *This is a group work which is written by me
*/

import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.awt.Color;

public class Jumper extends Actor {
  public Jumper() {
      // default color is red
    this.setColor(Color.RED);
  }

  public Jumper(Color color) {
    this.setColor(color);
  }

    // if can jump, jump
  public void act() {
    if (canJump()) {
      jump();
    } else {
      turn();
    }
  }

  public void jump() {
      // grid can not be empty, this is the precondiction, take care
    if (this.getGrid() == null) {
      return;
    } else {
      Location location = this.getLocation();
      Location nextLocation = location.getAdjacentLocation(this.getDirection());
      Location targetLocation = nextLocation.getAdjacentLocation(this.getDirection());

      if (this.getGrid().isValid(targetLocation)) {
        this.moveTo(targetLocation);
      } else {
        this.removeSelfFromGrid();
      }
    }
  }

  public void turn() {
    this.setDirection(this.getDirection() + Location.HALF_RIGHT);
  }

  public boolean canJump() {
    if (this.getGrid() == null) {
      return false;
    } else {
      Location location = this.getLocation();
      Location nextLocation = location.getAdjacentLocation(this.getDirection());

        // if the nextLocation is invalid, return false
      if (!this.getGrid().isValid(nextLocation)) {
        return false;
      } else {
        Actor nextActor = this.getGrid().get(nextLocation);

          // next Actor should be valid
        if (!((nextActor instanceof Flower) || (nextActor instanceof Rock) || nextActor == null)) {
          return false;
        } else {
            // targetLocation must be valid
          Location targetLocation = nextLocation.getAdjacentLocation(this.getDirection());

          if (!this.getGrid().isValid(targetLocation)) {
            return false;
          } else {
            Actor targetActor = this.getGrid().get(targetLocation);

              // what about rock, I don't know
            if (targetActor == null || (targetActor instanceof Flower)) {
              return true;
            } else {
              return false;
            }
          }
        }
      }
    }
  }
}
