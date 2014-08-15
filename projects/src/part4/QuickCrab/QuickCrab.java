  // <Copyright liaoqb>  [Copyright 2014.08.05]
import info.gridworld.grid.Location;
import java.util.ArrayList;

/*
   public ArrayList<Location> getMoveLocations() {
    ArrayList<Location> locations = new ArrayList<Location>();
    Location location = this.getLocation();
    Location leftLocation = location.getAdjacentLocation(Location.LEFT);
    Location rightLocation = location.getAdjacentLocation(Location.RIGHT);

    if (isEmpty(leftLocation, Location.LEFT)) {
      locations.add(leftLocation.getAdjacentLocation(Location.LEFT));
    }

    if (isEmpty(rightLocation, Location.RIGHT)) {
      locations.add(rightLocation.getAdjacentLocation(Location.RIGHT));
    }

    if (locations.size() == 0) {
      return super.getMoveLocations();
    } else {
      return locations;
    }
  }
 */

public class QuickCrab extends CrabCritter {
  public ArrayList<Location> getMoveLocations() {
    ArrayList<Location> locations = new ArrayList<Location>();
    Location location = this.getLocation();
    Location leftLocation = location.getAdjacentLocation(Location.LEFT);
    Location rightLocation = location.getAdjacentLocation(Location.RIGHT);

    if (isEmpty(leftLocation, Location.LEFT)) {
      locations.add(leftLocation.getAdjacentLocation(Location.LEFT));
    }

    if (isEmpty(rightLocation, Location.RIGHT)) {
      locations.add(rightLocation.getAdjacentLocation(Location.RIGHT));
    }

    if (locations.size() == 0) {
      return super.getMoveLocations();
    } else {
      return locations;
    }
  }

  private boolean isEmpty(Location location, int direction) {
    if ((!this.getGrid().isValid(location)) || (this.getGrid().get(location) != null)) {
      return false;
    } else {
      Location tempLocation = location.getAdjacentLocation(direction);

      if ((!this.getGrid().isValid(tempLocation)) || (this.getGrid().get(tempLocation) != null)) {
        return false;
      } else {
        return true;
      }
    }
  }
}
