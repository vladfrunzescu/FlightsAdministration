package socialnetwork.utils.observer;
import socialnetwork.utils.events.Event;
public interface Observable<E1 extends Event, E2 extends Event> {
    void addObserver(Observer<E1, E2> e);
    void removeObserver(Observer<E1, E2> e);
    void notifyObservers(E1 t1, E2 t2);
}