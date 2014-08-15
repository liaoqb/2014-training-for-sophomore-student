  // <Copyright liaoqb>  [Copyright 2014.08.05]
  // This is the RockHound
import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Critter;
import java.util.ArrayList;

/*
  public void processActors(ArrayList<Actor> actors) {
    for (int i = 0; i < actors.size(); ++i) {
      if (actors.get(i) instanceof Rock) {
        actors.get(i).removeSelfFromGrid();
      }
    }
  }
 * */

public class RockHound extends Critter {
  public void processActors(ArrayList<Actor> actors) {
    for (int i = 0; i < actors.size(); ++i) {
      if (actors.get(i) instanceof Rock) {
        actors.get(i).removeSelfFromGrid();
      }
    }
  }
}
