package event.lib;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class EventPlanner implements Serializable {

    private String name;
    private ArrayList<Event> events = new ArrayList<>();
    private ArrayList<Event> requestedEvents = new ArrayList<>();

    public String getName() {
        return this.name;
    }

    public ArrayList<Event> getEvents() {
        return this.events;
    }

    public ArrayList<Event> getRequestedEvents() {
        return this.requestedEvents;
    }

    public EventPlanner(String name) {
        this.name = name;
    }

    public String requestEvent(String eventTitle, String customerContact, LocalDate eventDate, int durationInDays, int numOfParticipants) {
        CorporateEvent event = new CorporateEvent(eventTitle, customerContact, eventDate, durationInDays, numOfParticipants);
        this.requestedEvents.add(event);
        return event.getEventId();
    }

    public void acceptEvent(String eventID) throws InvalidEventException {
        Event event = findRequestedEvent(eventID);
        this.requestedEvents.remove(event);
        this.events.add(event);
    }

    public String offerTourPackage(String eventTitle, LocalDate eventDate, int durationInDays, int numOfParticipants, int perPersonPrice, ArrayList<String> placesToVisit) {
        TourPackage tp = new TourPackage(eventTitle, eventDate, durationInDays, numOfParticipants, perPersonPrice);
        tp.setPlacesToVisit(placesToVisit);
        this.events.add(tp);
        return tp.getEventId();
    }

    public String offerTourPackage(String eventTitle, LocalDate eventDate, int durationInDays, int numOfParticipants, int perPersonPrice) {
        TourPackage tp = new TourPackage(eventTitle, eventDate, durationInDays, numOfParticipants, perPersonPrice);
        this.events.add(tp);
        return tp.getEventId();
    }

    public Event findEvent(String id) throws InvalidEventException {
        for (Event event : this.events) {
            if (event.getEventId().equalsIgnoreCase(id)) {
                return event;
            }
        }
        throw new InvalidEventException(id);
    }

    public Event findRequestedEvent(String id) throws InvalidEventException {
        for (Event event : this.requestedEvents) {
            if (event.getEventId().equalsIgnoreCase(id)) {
                return event;
            }
        }
        throw new InvalidEventException(id);
    }

    public ArrayList<Event> searchEvents(String title) {
        ArrayList<Event> foundEvents = new ArrayList<>();
        for (Event event : this.events) {
            if (event.getEventTitle().toLowerCase().contains(title.toLowerCase())) {
                foundEvents.add(event);
            }
        }
        return foundEvents;
    }

    public ArrayList<TourPackage> searchForTourPackages(String title) {
        ArrayList<TourPackage> foundEvents = new ArrayList<>();
        for (Event event : this.events) {
            if (event instanceof TourPackage && event.getEventTitle().toLowerCase().contains(title.toLowerCase())) {
                foundEvents.add((TourPackage) event);
            }
        }
        return foundEvents;
    }

    public void registerForTour(String tourId, int participants, String contact) throws InvalidEventException {
        Event evt = findEvent(tourId);
        if (evt instanceof TourPackage) {
            ((TourPackage) evt).registerForTour(participants, contact);
        }
    }

    public void assignEventManager(String eventID, String managerName) throws InvalidEventException {
        Event event = findEvent(eventID);
        event.setEventManager(managerName);
    }

    public void addEventTask(String eventID, String title, String description) throws InvalidEventException {
        Event event = findEvent(eventID);
        event.addTask(title, description);
    }

    public void startEventTask(String eventID, String title) throws InvalidEventException {
        Event event = findEvent(eventID);
        event.startTask(title);
    }

    public void completeEventTask(String eventID, String title) throws InvalidEventException {
        Event event = findEvent(eventID);
        event.completeTask(title);
    }

    public double payBill(String eventId) throws InvalidEventException {
        Event event = findEvent(eventId);
        return event.getBill();
    }
}
