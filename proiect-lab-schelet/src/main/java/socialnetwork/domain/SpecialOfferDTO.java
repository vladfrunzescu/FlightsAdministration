package socialnetwork.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class SpecialOfferDTO {

    private Double offerID;
    private HotelDTO hotel;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer percents;

    public SpecialOfferDTO(Double offerID, HotelDTO hotel, LocalDateTime startDate, LocalDateTime endDate, Integer percents) {
        this.offerID = offerID;
        this.hotel = hotel;
        this.startDate = startDate;
        this.endDate = endDate;
        this.percents = percents;
    }

    public Double getOfferID() {
        return offerID;
    }

    public void setOfferID(Double offerID) {
        this.offerID = offerID;
    }

    public String getHotelName(){
        return this.hotel.getHotelName();
    }

    public Double getHotelID(){
        return this.hotel.getID();
    }

    public String getLocation(){
        return this.hotel.getLocation();
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Integer getPercents() {
        return percents;
    }

    public void setPercents(Integer percents) {
        this.percents = percents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecialOfferDTO that = (SpecialOfferDTO) o;
        return percents == that.getPercents() &&
                this.getOfferID().equals(((SpecialOfferDTO) o).getOfferID()) &&
                Objects.equals(offerID, that.getOfferID()) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getOfferID(), hotel, startDate, endDate, percents);
    }
}
