package socialnetwork.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class SpecialOffer extends Entity<Double>{
    private Double hotelID;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer percents;

    public SpecialOffer(Double hotelID, LocalDateTime startDate, LocalDateTime endDate, Integer percents) {
        this.hotelID = hotelID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.percents = percents;
    }

    public SpecialOffer(Double ID, Double hotelID, LocalDateTime startDate, LocalDateTime endDate, Integer percents) {
        this.setId(ID);
        this.hotelID = hotelID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.percents = percents;
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
        SpecialOffer that = (SpecialOffer) o;
        return percents == that.percents &&
                this.getId().equals(((SpecialOffer) o).getId()) &&
                Objects.equals(hotelID, that.hotelID) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), hotelID, startDate, endDate, percents);
    }
}
