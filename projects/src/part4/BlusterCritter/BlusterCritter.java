  // <Copyright liaoqb>  [Copyright 2014.08.05]
  // This is the BlusterCritter
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.util.ArrayList;

import java.awt.Color;


/*
    ArrayList<Actor> actors = new ArrayList<Actor>();
    Location location = this.getLocation();
    int row = location.getRow();
    int col = location.getCol();

    for (int i = row - 2; i <= row + 2; ++i) {
      for (int j = col - 2; j <= col + 2; ++j) {
        Location temp = new Location(i, j);

        if (this.getGrid().isValid(temp)) {
          Actor actor = this.getGrid().get(temp);

          if (actor != this && actor != null && (actor instanceof Critter)) {
            actors.add(actor);
          }
        }
      }
    }

*/
public class BlusterCritter extends Critter {
  private int courage;
  private static final int FACTOR = 1;

  public BlusterCritter(int courage) {
    this.courage = courage;
  }

    // This is the core code, take care
  public ArrayList<Actor> getActors() {
    ArrayList<Actor> actors = new ArrayList<Actor>();
    Location location = this.getLocation();
    int row = location.getRow();
    int col = location.getCol();

    for (int i = row - 2; i <= row + 2; ++i) {
      for (int j = col - 2; j <= col + 2; ++j) {
        Location temp = new Location(i, j);

        if (this.getGrid().isValid(temp)) {
          Actor actor = this.getGrid().get(temp);

          if (actor != this && actor != null && (actor instanceof Critter)) {
            actors.add(actor);
          }
        }
      }
    }

    return actors;
  }

  public void processActors(ArrayList<Actor> actors) {
    Color color = this.getColor();
    int red = color.getRed();
    int green = color.getGreen();
    int blue = color.getBlue();

    if (this.courage < actors.size()) {
      red -= FACTOR;
      green -= FACTOR;
      blue -= FACTOR;
    } else {
      red += FACTOR;
      green += FACTOR;
      blue += FACTOR;
    }

      // control the range in the color
    red = (red > 255 ? 255 : red);
    green = (green > 255 ? 255 : green);
    blue = (blue > 255 ? 255 : blue);

    red = (red < 0 ? 0 : red);
    green = (green < 0 ? 0 : green);
    blue = (blue < 0 ? 0 : blue);

    this.setColor(new Color(red, green, blue));
  }
}
