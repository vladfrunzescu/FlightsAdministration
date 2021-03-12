package socialnetwork.service;

import socialnetwork.controller.ProfileController;
import socialnetwork.domain.*;
import socialnetwork.repository.Repository;
import socialnetwork.utils.Hobbies;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    public Repository<Double, Reservation> repoReservation;
    public List<ProfileController> profileControllers = new ArrayList<>();

   public ReservationService(Repository<Double, Reservation> repoReservation){
        this.repoReservation = repoReservation;
    }

    public Iterable<Reservation> getAll(){
        return repoReservation.findAll();
    }

    public Reservation getSpecialOffer(Double ID) { return repoReservation.findOne(ID);}

    public void addReservation(Reservation reservation, Client client){
        repoReservation.save(reservation);
        notifyProfile(client);
    }

    public List<Reservation> getAllForClient(Client client){
        List <Reservation> newList = new ArrayList<>();
        for(Reservation r : getAll()){
            if(r.getClientID().equals(client.getId())){
                newList.add(r);
            }
        }
        return newList;
    }

    public void addProfile(ProfileController profileController){
       profileControllers.add(profileController);
    }

    public void notifyProfile(Client client){
       profileControllers.stream().forEach(x -> x.mesaj(client));
    }
}
