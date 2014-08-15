  // <Copyright liaoqb>  [Copyright 2014.08.05]
  // This is the group, just for exercise
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import java.util.ArrayList;

public class KingCrab extends CrabCritter {
  public void processActors(ArrayList<Actor> actors) {
      // crabAdjecentLocations
    ArrayList<Location> crabAdjacentLocations = this.getGrid().getValidAdjacentLocations(this.getLocation());

    for (int i = 0; i < actors.size(); ++i) {
      ArrayList<Location> moveLocations = new ArrayList<Location>();
      ArrayList<Location> actorEmptyAdjacentLocations = this.getGrid().getEmptyAdjacentLocations(actors.get(i).getLocation());

      for (int j = 0; j < actorEmptyAdjacentLocations.size(); ++j) {
          // is in the actor
        boolean isIn = false;
        for (int k = 0; k < crabAdjacentLocations.size(); ++k) {
          if (actorEmptyAdjacentLocations.get(j).equals(crabAdjacentLocations.get(k))) {
            isIn = true;
            break;
          }
        }

        if (!isIn) {
          moveLocations.add(actorEmptyAdjacentLocations.get(j));
        }
      }

      if (moveLocations.size() == 0) {
        actors.get(i).removeSelfFromGrid();
      } else {
          // move to a random position
        actors.get(i).moveTo(moveLocations.get((int)(Math.random() * moveLocations.size())));
      }
    }
  }
}
