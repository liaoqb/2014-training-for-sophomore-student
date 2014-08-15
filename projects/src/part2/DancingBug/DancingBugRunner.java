  // <Copyright liaoqb>  [Copyright 2014.08.04]
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

public final class DancingBugRunner {
  private DancingBugRunner() {}
  
  public static void main(String[] args) {
      // dancing array
    int[] dArray = {1, 3, 2, 4, 5};
    ActorWorld world = new ActorWorld();

      // pass the dancingArray to the constructor
    DancingBug alice = new DancingBug(dArray);

    alice.setColor(Color.ORANGE);

      // init location is (3, 2)
    world.add(new Location(3, 2), alice);

    world.show();
  }
}
