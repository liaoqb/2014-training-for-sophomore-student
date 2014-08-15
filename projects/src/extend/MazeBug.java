  // <Copyright liaoqb>  [Copyright 2014.08.08]
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

/**
 * A <code>MazeBug</code> can find its way in a maze. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class MazeBug extends Bug {
	public Location next;
	public Location last;
	public boolean isEnd = false;
	public Stack<ArrayList<Location>> crossLocation = new Stack<ArrayList<Location>>();
	public Integer stepCount = 0;
	boolean hasShown = false;//final message has been shown

	/**
	 * Constructs a box bug that traces a square of a given side length
	 * 
	 * @param length
	 *            the side length
	 */
	public MazeBug() {
		setColor(Color.GREEN);
    last = new Location(0, 0);
	}

	/**
	 * Moves to the next location of the square.
	 */
	public void act() {
		boolean willMove = canMove();
		if (isEnd == true) {
		//to show step count when reach the goal		
			if (hasShown == false) {
				String msg = stepCount.toString() + " steps";
				JOptionPane.showMessageDialog(null, msg);
				hasShown = true;
			}
		} else if (willMove) {
			move();
			//increase step count when move 
			stepCount++;
		} else {
      turn();
      turn();
    }
	}

	/**
	 * Find all positions that can be move to.
	 * 
	 * @param loc
	 *            the location to detect.
	 * @return List of positions.
	 */
	public ArrayList<Location> getValid(Location loc) {
		Grid<Actor> gr = getGrid();
		if (gr == null) {
			return null;
    }

		ArrayList<Location> valid = new ArrayList<Location>();

    int[] validArray = {Location.EAST, Location.SOUTH, Location.WEST, Location.NORTH};

      // find direction
    for (int i = 0; i < validArray.length; ++i) {
      Location location = loc.getAdjacentLocation(validArray[i]);

        // System.out.printf("(%d, %d)\n", location.getRow(), location.getCol());
      if (gr.isValid(location) && !location.equals(this.getLocation()) && !location.equals(last)) {
 
        if (gr.get(location) == null || gr.get(location) instanceof Flower ||
            (gr.get(location) instanceof Rock && gr.get(location).getColor().getRGB() == Color.RED.getRGB())) {
          valid.add(location);
        }
      }
    }
		
		return valid;
	}

	public boolean canMove() {
      // This is the core function, take care
    ArrayList<Location> locations = this.getValid(this.getLocation());

    if (locations.size() == 0) {
        // if dead load, exchange direction

      last = this.getLocation();
      return false;
        // if one load
    } else if (locations.size() == 1 && (crossLocation.empty() ||
          !this.getLocation().equals(crossLocation.peek().get(0)))) {

        // set nextLocation
      next = locations.get(0);
      last = this.getLocation();

      return true;
    } else {
      if (!crossLocation.empty() && this.getLocation().equals(crossLocation.peek().get(0))) {

        ArrayList<Location> cLocations = crossLocation.peek();
        ArrayList<Location> nullLocations = new ArrayList<Location>();

            // find the empty location
        for (int i = 2; i < cLocations.size(); ++i) {
          if (!(this.getGrid().get(cLocations.get(i)) instanceof Flower)) {
            nullLocations.add(cLocations.get(i));
          }
        }

          // if all the location had been set
        if (nullLocations.size() == 0) {
          next = cLocations.get(1);
          last = this.getLocation();

          crossLocation.pop();
        } else {
          Random random = new Random();

          int rand = random.nextInt(nullLocations.size());

          next = nullLocations.get(rand);
          last = this.getLocation();
        }

        return true;
      } else {
        ArrayList<Location> cLocations = new ArrayList<Location>();

            // add the last and this location
        cLocations.add(this.getLocation());
        cLocations.add(last);

        for (int i = 0; i < locations.size(); ++i) {
          cLocations.add(locations.get(i));
        }

            // select a road randomly
        Random random = new Random();
        int rand = random.nextInt(locations.size());

        next = locations.get(rand);
        last = this.getLocation();

        crossLocation.push(cLocations);

        return true;          
      }
    }
	}
	/**
	 * Tests whether this bug can move forward into a location that is empty or
	 * contains a flower.
	 * 
	 * @return true if this bug can move.
	 */

	/**
	 * Moves the bug forward, putting a flower into the location it previously
	 * occupied.
	 */
	public void move() {
		Grid<Actor> gr = getGrid();

		if (gr == null) {
			return;
    }

		Location loc = getLocation();

		if (gr.isValid(next)) {
      if (gr.get(next) instanceof Rock) {
        isEnd = true;
      }

			setDirection(getLocation().getDirectionToward(next));
			moveTo(next);
		} else {
			removeSelfFromGrid();
    }

		Flower flower = new Flower(getColor());
		flower.putSelfInGrid(gr, loc);
	}
}
