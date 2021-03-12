package socialnetwork.service;
import socialnetwork.domain.*;
import socialnetwork.repository.Repository;
public class SuperService {
    private HotelService hotelService;
    private LocationService locationService;
    private OfferService offerService;
    private ReservationService reservationService;

    public SuperService() {
    }

    public SuperService(HotelService hotelService, LocationService locationService, OfferService offerService, ReservationService reservationService) {
        this.hotelService = hotelService;
        this.locationService = locationService;
        this.offerService = offerService;
        this.reservationService = reservationService;
    }

    public HotelService getHotelService() {

        return this.hotelService;
    }

    public LocationService getLocationService() {

        return this.locationService;
    }

    public ReservationService getReservationService() {
        return reservationService;
    }

    public OfferService getOfferService() {

        return offerService;
    }
}