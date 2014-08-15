  // <Copyright liaoqb>  [Copyright 2014.08.06]
/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 */

import info.gridworld.actor.Actor;
import java.awt.Color;

import java.util.ArrayList;

/**
 * A <code>ChameleonCritter</code> takes on the color of neighboring actors as
 * it moves through the grid. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */

class ModifiedChameleonCritter extends ChameleonCritter {
  private final double FACTOR = 0.1;

  public void processActors(ArrayList<Actor> actors) {
    if (actors.size() == 0) {
      Color color = this.getColor();

      int red = (int)(color.getRed() * (1 - FACTOR));
      int green = (int)(color.getGreen() * (1 - FACTOR));
      int blue = (int)(color.getBlue() * (1 - FACTOR));

      this.setColor(new Color(red, green, blue));
    } else {
        // set the old color
      this.setColor(actors.get((int)(Math.random() * actors.size())).getColor());
    }
  }
}
