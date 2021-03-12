package socialnetwork.domain;

import socialnetwork.utils.Hobbies;
import socialnetwork.utils.Type;

import java.util.List;
import java.util.Objects;

public class Hotel extends Entity<Double>{
    private Double locationID;
    private String hotelName;
    private Integer noRooms;
    private Double pricePerNight;
    private Type type;

    public Hotel(Double locationID, String hotelName, Integer noRooms, Double pricePerNight, Type type) {
        this.locationID = locationID;
        this.hotelName = hotelName;
        this.noRooms = noRooms;
        this.pricePerNight = pricePerNight;
        this.type = type;
    }

    public Hotel(Double ID, Double locationID, String hotelName, Integer noRooms, Double pricePerNight, Type type) {
        this.setId(ID);
        this.locationID = locationID;
        this.hotelName = hotelName;
        this.noRooms = noRooms;
        this.pricePerNight = pricePerNight;
        this.type = type;
    }

    public Double getLocationID() {
        return locationID;
    }

    public void setLocationID(Double locationID) {
        this.locationID = locationID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
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
                "location ID='" + locationID + '\'' +
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
                getLocationID().equals(that.getLocationID()) &&
                getId().equals(that.getId()) &&
                getNoRooms() == that.getNoRooms()
                && getPricePerNight() == that.getPricePerNight()
                && getType().equals(that.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLocationID(), getHotelName(),getNoRooms(), getPricePerNight(), getType());
    }
}