  // <Copyright liaoqb>  [Copyright 2014.08.04]

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

public final class ZBugRunner {
  private ZBugRunner() {}

  public static void main(String[] args) {
    ActorWorld world = new ActorWorld();
    ZBug alice = new ZBug(4);

    alice.setColor(Color.RED);

    world.add(new Location(4, 1), alice);

    world.show();
  }
}
