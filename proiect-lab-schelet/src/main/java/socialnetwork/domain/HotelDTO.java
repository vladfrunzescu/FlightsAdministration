package socialnetwork.domain;

import socialnetwork.utils.Hobbies;
import socialnetwork.utils.Type;

import java.util.List;
import java.util.Objects;

public class HotelDTO {
    private Double ID;
    private Location location;
    private String hotelName;
    private Integer noRooms;
    private Double pricePerNight;
    private Type type;

    public HotelDTO(Location location, String hotelName, Integer noRooms, Double pricePerNight, Type type) {
        this.location = location;
        this.hotelName = hotelName;
        this.noRooms = noRooms;
        this.pricePerNight = pricePerNight;
        this.type = type;
    }

    public HotelDTO(Double ID, Location location, String hotelName, Integer noRooms, Double pricePerNight, Type type) {
        this.ID = ID;
        this.location = location;
        this.hotelName = hotelName;
        this.noRooms = noRooms;
        this.pricePerNight = pricePerNight;
        this.type = type;
    }

    public Double getID() {
        return ID;
    }

    public void setID(Double ID) {
        this.ID = ID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getLocation(){
        return location.getLocationName();
    }

    public Integer getNoRooms() {
        return noRooms;
    }

    public void setNoRooms(Integer noRooms) {
        this.noRooms = noRooms;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "location ID='" + location + '\'' +
                "Hotel Name='" + hotelName + '\'' +
                ", NoRooms='" + noRooms + '\'' +
                ", PricePerNight'" + pricePerNight + '\'' +
                ", Type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hotel)) return false;
        Hotel that = (Hotel) o;
        return getHotelName().equals(that.getHotelName()) &&
                location.equals(that.getLocationID()) &&
                ID.equals(that.getId()) &&
                getNoRooms() == that.getNoRooms()
                && getPricePerNight() == that.getPricePerNight()
                && getType().equals(that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, location, getHotelName(),getNoRooms(), getPricePerNight(), getType());
    }
}