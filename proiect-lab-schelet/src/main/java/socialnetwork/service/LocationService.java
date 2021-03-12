package socialnetwork.service;

import socialnetwork.domain.Location;
import socialnetwork.repository.Repository;

public class LocationService //extends SuperService implements Observable<MessageChangeEvent, MembruChangeEvent>
{
    private Repository<Double, Location> repoLocation;

    public LocationService(Repository<Double, Location> repo) {
        this.repoLocation = repo;
    }
/*
    private List<Observer<MessageChangeEvent, MembruChangeEvent>> observers = new ArrayList<>();
    @Override
    public void addObserver(Observer<MessageChangeEvent, MembruChangeEvent> e) {
        observers.add(e);
    }
    @Override
    public void removeObserver(Observer<MessageChangeEvent, MembruChangeEvent> e) {
        observers.remove(e);
    }
    @Override
    public void notifyObservers(MessageChangeEvent t1,MembruChangeEvent t2) {
        observers.stream()
                .forEach(x -> x.updateMessageEvent(t1));

        observers.stream()
                .forEach(x -> x.updateMemberEvent(t2));

    }

 */

    public Iterable<Location> getAll(){
        return repoLocation.findAll();
    }

    public Location getLocation(Double ID) { return repoLocation.findOne(ID);
    }

}
