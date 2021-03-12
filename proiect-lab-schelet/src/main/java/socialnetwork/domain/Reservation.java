package socialnetwork.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reservation extends Entity<Double>{

    private Long clientID;
    private Double hotelID;
    private LocalDateTime startDate;
    private Integer noNights;

    public Reservation(Long clientID, Double hotelID, LocalDateTime startDate, Integer noNights) {
        this.setId(generateRandomId());
        this.clientID = clientID;
        this.hotelID = hotelID;
        this.startDate = startDate;
        this.noNights = noNights;
    }

    public Reservation(Double ID, Long clientID, Double hotelID, LocalDateTime startDate, Integer noNights) {
        this.setId(ID);
        this.clientID = clientID;
        this.hotelID = hotelID;
        this.startDate = startDate;
        this.noNights = noNights;
    }

    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    public Double getHotelID() {
        return hotelID;
    }

    public void setHotelID(Double hotelID) {
        this.hotelID = hotelID;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public Integer getNoNights() {
        return noNights;
    }

    public void setNoNights(Integer noNights) {
        this.noNights = noNights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return noNights == that.noNights &&
                this.getId().equals(((Reservation) o).getId()) &&
                Objects.equals(clientID, that.clientID) &&
                Objects.equals(hotelID, that.hotelID) &&
                Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), clientID, hotelID, startDate, noNights);
    }

    private Double generateRandomId() {
        double leftLimit = 1d;
        double rightLimit = 1000000000d;
        double generatedDouble = leftLimit + (double) (Math.random() * (rightLimit - leftLimit));
        return generatedDouble;
    }
}
