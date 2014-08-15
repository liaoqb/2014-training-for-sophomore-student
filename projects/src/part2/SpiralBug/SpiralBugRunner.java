  // <Copyright liaoqb>  [Copyright 2014.08.04]

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;

import java.awt.Color;

public final class SpiralBugRunner {
  private SpiralBugRunner() {}
  
  public static void main(String[] args) {
    ActorWorld world = new ActorWorld(new UnboundedGrid());
    SpiralBug alice = new SpiralBug(2);

    alice.setColor(Color.RED);

    world.add(new Location(2, 5), alice);
    world.show();
  }
}
