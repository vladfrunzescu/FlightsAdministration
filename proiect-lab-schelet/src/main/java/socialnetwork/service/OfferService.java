package socialnetwork.service;

import org.graalvm.compiler.nodes.cfg.LocationSet;
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

public class OfferService //extends SuperService implements Observable<MessageChangeEvent, MembruChangeEvent>
{
    private Repository<Double, SpecialOffer> repoOffer;
    private LocationService locationService;
    private HotelService hotelService;

    public void setHotelService(HotelService hotelService){
        this.hotelService = hotelService;
    }

    public void setLocationService(LocationService locationService){
        this.locationService = locationService;
    }

    public List<SpecialOfferDTO> TransformaDTO(Iterable<SpecialOffer> oferte){
        List<SpecialOfferDTO>  oferteDTO= new ArrayList<>();
        for(SpecialOffer s : oferte){

            Hotel hotelSimplu = hotelService.getHotel(s.getHotelID());
            HotelDTO hotel = new HotelDTO(hotelSimplu.getId(),  locationService.getLocation(hotelSimplu.getLocationID()),  hotelSimplu.getHotelName(), hotelSimplu.getNoRooms(), hotelSimplu.getPricePerNight(), hotelSimplu.getType());
            SpecialOfferDTO oferta = new SpecialOfferDTO(s.getId(), hotel, s.getStartDate(), s.getEndDate(), s.getPercents());
            oferteDTO.add(oferta);
        }
        return oferteDTO;
    }

    public OfferService(Repository<Double, SpecialOffer> repoOffer) {
        this.repoOffer = repoOffer;
    }

    public Iterable<SpecialOffer> getAll(){
        return repoOffer.findAll();
    }

    public SpecialOffer getSpecialOffer(Double ID) { return repoOffer.findOne(ID);}

    public List<SpecialOfferDTO> getSpecialOfferDate (LocalDateTime start, LocalDateTime end, Double HotelID){
        List <SpecialOfferDTO> newList = new ArrayList<>();
        for(SpecialOffer s : getAll()){
            if(s.getHotelID().equals(HotelID) && s.getStartDate().isAfter(start) && s.getEndDate().isBefore(end)){
                Hotel hotelSimplu = hotelService.getHotel(s.getHotelID());
                HotelDTO hotel = new HotelDTO(hotelSimplu.getId(),  locationService.getLocation(hotelSimplu.getLocationID()),  hotelSimplu.getHotelName(), hotelSimplu.getNoRooms(), hotelSimplu.getPricePerNight(), hotelSimplu.getType());
                SpecialOfferDTO oferta = new SpecialOfferDTO(s.getId(), hotel, s.getStartDate(), s.getEndDate(), s.getPercents());
                newList.add(oferta);
            }
        }
        return newList;
    }

    public List<SpecialOfferDTO> getSpecialOfferHotel ( Double HotelID){
        List <SpecialOfferDTO> newList = new ArrayList<>();
        for(SpecialOffer s : getAll()){
            if(s.getHotelID().equals(HotelID)){
                Hotel hotelSimplu = hotelService.getHotel(s.getHotelID());
                HotelDTO hotel = new HotelDTO(hotelSimplu.getId(),  locationService.getLocation(hotelSimplu.getLocationID()),  hotelSimplu.getHotelName(), hotelSimplu.getNoRooms(), hotelSimplu.getPricePerNight(), hotelSimplu.getType());
                SpecialOfferDTO oferta = new SpecialOfferDTO(s.getId(), hotel, s.getStartDate(), s.getEndDate(), s.getPercents());
                newList.add(oferta);
            }
        }
        return newList;
    }


    public List<SpecialOfferDTO> getSpecialOfferClient ( Client client ){
        List <SpecialOfferDTO> newList = new ArrayList<>();
        for(SpecialOffer s : getAll()){
            if(client.getFidelityGrade() > s.getPercents() && s.getEndDate().isAfter(LocalDateTime.now())){
                Hotel hotelSimplu = hotelService.getHotel(s.getHotelID());
                HotelDTO hotel = new HotelDTO(hotelSimplu.getId(),  locationService.getLocation(hotelSimplu.getLocationID()),  hotelSimplu.getHotelName(), hotelSimplu.getNoRooms(), hotelSimplu.getPricePerNight(), hotelSimplu.getType());
                SpecialOfferDTO oferta = new SpecialOfferDTO(s.getId(), hotel, s.getStartDate(), s.getEndDate(), s.getPercents());
                newList.add(oferta);
            }
        }
        return newList;
    }

}
