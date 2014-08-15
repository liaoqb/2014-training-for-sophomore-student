  // <Copyright liaoqb>  [Copyright 2014.08.05]
  // JumperRunner

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
import info.gridworld.actor.Flower;
import java.awt.Color;

public final class JumperRunner {
  private JumperRunner() {}

  public static void main(String[] args) {
    ActorWorld world = new ActorWorld();

    Jumper alice = new Jumper();
    Bug bug = new Bug();
    Flower flower = new Flower();

    alice.setColor(Color.BLUE);

    world.add(new Location(3, 2), alice);
    world.add(new Location(5, 2), bug);
    world.add(new Location(6, 2), flower);
    world.show();
  }
}
