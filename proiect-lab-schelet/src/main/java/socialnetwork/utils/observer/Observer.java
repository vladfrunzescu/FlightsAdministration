package socialnetwork.utils.observer;
import socialnetwork.utils.events.Event;
public interface Observer<E1 extends Event, E2 extends Event> {
    void updateMessageEvent(E1 e);
    void updateMemberEvent(E2 e);
}