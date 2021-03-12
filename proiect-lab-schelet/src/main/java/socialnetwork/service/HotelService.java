package socialnetwork.service;

import socialnetwork.domain.*;
import socialnetwork.repository.Repository;
import socialnetwork.utils.events.ChangeEventType;
import socialnetwork.utils.observer.Observable;
import socialnetwork.utils.observer.Observer;
import sun.security.x509.OIDMap;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HotelService //extends SuperService implements Observable<MessageChangeEvent, MembruChangeEvent>
{
    private Repository<Double, Hotel> repoHotel;
    private LocationService locationService;

    public void setLocationService(LocationService locationService){
        this.locationService = locationService;
    }

    public List<HotelDTO> TransformaDTO(Iterable<Hotel> hoteluri){
        List<HotelDTO>  hoteluriDTO= new ArrayList<>();
        for(Hotel h : hoteluri){
            HotelDTO hotel = new HotelDTO(h.getId(), locationService.getLocation(h.getLocationID()), h.getHotelName(), h.getNoRooms(), h.getPricePerNight(), h.getType());
            hoteluriDTO.add(hotel);
        }
        return hoteluriDTO;
    }

    public HotelService(Repository<Double, Hotel> repoHotel) {
        this.repoHotel = repoHotel;
    }

    public Iterable<Hotel> getAll(){
        return repoHotel.findAll();
    }

    public Hotel getHotel(Double ID) { return repoHotel.findOne(ID);}

    public List<HotelDTO> getHotelLocatie (Location location){
        List <HotelDTO> newList = new ArrayList<>();
        for(Hotel h : getAll()){
            if(h.getLocationID().equals(location.getId())){
                HotelDTO hotel = new HotelDTO(h.getId(), locationService.getLocation(h.getLocationID()), h.getHotelName(), h.getNoRooms(), h.getPricePerNight(), h.getType());
                newList.add(hotel);
            }
        }

        return newList;
    }
}
