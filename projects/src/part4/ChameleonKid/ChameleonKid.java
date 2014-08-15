  // <Copyright liaoqb>  [Copyright 2014.08.05]
  // This is the group work, just for fun

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import java.util.ArrayList;

import java.awt.Color;


/*
   public ArrayList<Actor> getActors() {
    ArrayList<Actor> actors = new ArrayList<Actor>();

    int[] directions = {Location.AHEAD, Location.HALF_CIRCLE};
    Location location = this.getLocation();

    for (int i = 0; i < directions.length; ++i) {
      Location adjacentLocation =
      location.getAdjacentLocation(this.getDirection() + directions[i]);

      if (this.getGrid().isValid(adjacentLocation)) {
        Actor actor = this.getGrid().get(adjacentLocation);

        if (actor != null) {
          actors.add(actor);
        }
      }
    }

    return actors;
  }
 */
public class ChameleonKid extends ChameleonCritter {
  private static final double DARK_FACTOR = 0.05;
    // return the location that is in front of or behind
  public ArrayList<Actor> getActors() {
    ArrayList<Actor> actors = new ArrayList<Actor>();

    int[] directions = {Location.AHEAD, Location.HALF_CIRCLE};
    Location location = this.getLocation();

    for (int i = 0; i < directions.length; ++i) {
      Location adjacentLocation =
      location.getAdjacentLocation(this.getDirection() + directions[i]);

      if (this.getGrid().isValid(adjacentLocation)) {
        Actor actor = this.getGrid().get(adjacentLocation);

        if (actor != null) {
          actors.add(actor);
        }
      }
    }

    return actors;
  }

  public void processActors(ArrayList<Actor> actors) {
    if (actors.size() == 0) {
      Color color = this.getColor();

      int red = (int)(color.getRed() * (1 - DARK_FACTOR));
      int green = (int)(color.getGreen() * (1 - DARK_FACTOR));
      int blue = (int)(color.getBlue() * (1 - DARK_FACTOR));

      this.setColor(new Color(red, green, blue));
    } else {
      int select = (int)(Math.random() * actors.size());
      this.setColor(actors.get(select).getColor());
    }
  }
}
