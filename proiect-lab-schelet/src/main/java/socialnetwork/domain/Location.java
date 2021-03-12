package socialnetwork.domain;

import socialnetwork.utils.Hobbies;

import java.util.List;
import java.util.Objects;

public class Location extends Entity<Double>{
    private String locationName;

    public Location( String locationName) {
        this.locationName = locationName;
    }

    public Location( Double ID, String locationName) {
        this.setId(ID);
        this.locationName = locationName;
    }


    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public String toString() {
        return "Location{" +
                "ID= " + getId() +'\'' +
                "Location Name=" + locationName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location that = (Location) o;
        return getLocationName().equals(that.getLocationName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocationName());
    }
}