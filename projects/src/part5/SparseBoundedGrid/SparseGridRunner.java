  // <Copyright liaoqb>  [Copyright 2014.08.06]
  // import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Bug;
/**
* This class runs a world with additional grid choices.
*/
public final class SparseGridRunner {
  private SparseGridRunner() {}

    // public class for the runner
  public static void main(String[] args) {
    ActorWorld world = new ActorWorld();
    Bug bug1 = new Bug();

    Bug bug2 = new Bug();

      // show the map
    world.addGridClass("SparseBoundedGrid");
    world.addGridClass("SparseBoundedGrid2");
    world.addGridClass("SparseBoundedGrid3");
    world.addGridClass("UnboundedGrid2");
    world.add(new Location(2, 2), new Critter());
    world.add(new Location(3, 3), bug1);
    world.add(new Location(4, 4), bug2);
    world.show();
  }
}
