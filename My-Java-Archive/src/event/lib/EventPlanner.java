/*package event.lib;

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
}*/

package event.lib;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class EventPlanner {
    public String name;
    private ArrayList<Event> events=new ArrayList<>();
    private ArrayList<Event> requestedEvents=new ArrayList<>();
    public static File eventFile=new File("event.ser");
    public static File requestedFile=new File("requestedFile.ser");
    public ArrayList<Event> getRequestedEvents() {
        return requestedEvents;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public EventPlanner(String name) {
        this.name = name;
    }

    // method a
    public Event findEvent(String id) throws Exception {
        for (Event it : events) {
            if (it.getEventId().equals(id)) {
                return it;
            }
        }
        throw new Exception("This");
    }

    // method b
    public Event findRequestedEvent(String id)throws Exception  {
        for (Event it : requestedEvents) {
            if (it.getEventId().equals(id)) {
                return it;
            }
        }
        throw new Exception("This");
    }

    // method c
    public ArrayList<Event> searchEvents(String title) {
        ArrayList<Event> ans = new ArrayList<>();
        for (Event it : events) {
            if (it.getEventTitle().equals(ans)) {
                ans.add(it);
            }
        }
        return ans;
    }

    // method d
    public ArrayList<TourPackage> searchForTourPackages(String title) {
        ArrayList<TourPackage> ans = new ArrayList<>();
        for (Event it : events) {
            String chk = it.getEventId();
            if (chk.charAt(0) == 'T' && chk.charAt(1) == 'P' && it.getEventTitle().equals(title)) {
                ans.add(new TourPackage(it.getEventTitle(),it.getEventDate(),it.getDurationInDays(),
                        it.getNumOfParticipants(),it.getUnitPrice()));
            }
        }
        return ans;
    }

    // method e
    public String requestEvent(String eventTitle, String customerContact, LocalDate eventDate, int durationInDays,
                               int numOfParticipants) {
        CorporateEvent chk = new CorporateEvent(eventTitle, customerContact, eventDate, durationInDays,
                numOfParticipants);
        requestedEvents.add(chk);
        return chk.getEventId();
    }

    // method f
    public void acceptEvent(String eventID) throws Exception {
        Event chk = findRequestedEvent(eventID);
        if (chk != null) {
            events.add(chk);
            requestedEvents.remove(chk);
        }
    }

    // method g
    public String offerTourPackage(String eventTitle, LocalDate eventDate, int durationInDays, int numOfParticipants,
                                   int perPersonPrice,
                                   ArrayList<String> placesToVisit) {
        TourPackage chk = new TourPackage(eventTitle, eventDate, durationInDays, numOfParticipants,
                perPersonPrice);
        for(String place:placesToVisit)chk.addPlacesToVisit(place);
        events.add(chk);
        return chk.getEventId();
    }

    // method h
    public String offerTourPackage(String eventTitle, LocalDate eventDate, int durationInDays, int numOfParticipants,
                                   int perPersonPrice) {
        TourPackage chk = new TourPackage(eventTitle,eventDate, durationInDays, numOfParticipants,
                perPersonPrice);
        events.add(chk);
        return chk.getEventId();
    }

    // method i
    public void registerForTour(String tourId, int participants, String contact) throws Exception {
        Event chk = findEvent(tourId);
        if (chk != null) {
            ((TourPackage)chk).registerForTour(participants, contact);
        }
//        System.out.println(events);

    }

    // method j
    public void assignEventManager(String eventID, String managerName) throws Exception {
        Event chk = findEvent(eventID);
        if (chk != null) {
            chk.setEventManager(managerName);
        }
    }

    // method k
    public void addEventTask(String eventID, String title, String description) throws Exception {
        Event chk = findEvent(eventID);
        if (chk != null) {
            chk.addTask(title, description);
//            System.out.println("Done");
//            return true;
        }
//        System.out.println("Not Done");
//        return false;
    }

    // method l
    public void startEventTask(String eventID, String title) throws Exception {
        Event chk = findEvent(eventID);
        if (chk != null) {
            chk.startTask(title);
//            System.out.println("Done");
        }
//        System.out.println("Not Done");
    }

    // method m
    public void completeEventTask(String eventID, String title) throws Exception {
        Event chk = findEvent(eventID);
        if (chk != null) {
            chk.completeTask(title);
//            System.out.println("Done");
        }
//        System.out.println("Not Done");
    }

    // method n
    public double payBill(String eventId) throws Exception{
        Event chk = findEvent(eventId);
        if (chk != null) {
            return chk.getBill();
        }
        return -1;
    }


//   custom method start
    // testing purpose only

    // method custom1
    public String showEvents(){
        String ans = "";
        for(Event it : events){
            ans += it.toString();
            ans+="\n";
        }
        return ans;
    }

    // method custom2
    public String showRequestedEvents(){
        if(requestedEvents.size()>0){
            return requestedEvents.toString();
        }
        else return "No events found.";
    }

    // method custom3
    public void acceptedEvent(){
        for (Event it : events) {
//            System.err.println(it);
        }
    }

    // method custom4
    public String viewAllEvents(){
        String ans="";
        for(Event it : events){
            ans+=it.toString();
            ans+="\n";
        }
        for(Event it : requestedEvents){
            ans+=it.toString();
            ans+="\n";
        }
        return ans;
    }
    //   show corporate events
    public String showCorporateEvents(){
        String ans="";
        for(Event it : events){
            if(it instanceof CorporateEvent){
                ans+=it.toString();
                ans+="\n";
            }
        }
        return ans;
    }
    //  show tourpacakge
    public String showTourPackages(){
        String ans="";
        for(Event it : events){
            if(it instanceof TourPackage){
                System.out.println(((TourPackage) it).customerContacts);
                ans+="Id:"+(it.getEventId()+", Tour title: "+it.getEventTitle()+", Date: "+it.getEventDate()+", Durations day: "+it.getDurationInDays()+", Unit Price: "+it.getUnitPrice()+", Total Slots: "+it.getNumOfParticipants()+", Registered People: "+((TourPackage) it).getNumOfRegisteredParticipants());
                ans+="\n";
            }
        }
//        System.out.println(ans);
        return ans;
    }
    //    custom method end
//  save data start
    public void saveData(){
        try {
            if(!eventFile.exists()){
                eventFile.createNewFile();
            }
            if(!requestedFile.exists()){
                requestedFile.createNewFile();
            }
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(eventFile));
            ObjectOutputStream oos2=new ObjectOutputStream(new FileOutputStream(requestedFile));
            oos.writeObject(events);
            oos2.writeObject(requestedEvents);
            oos.close();
        }
        catch (Exception e)
        {
            System.out.println("Error given save data");
        }
    }
    //  save data end
//    load data start
    public void loadData(){
        try{
            if(!eventFile.exists()){
                eventFile.createNewFile();
            }
            if(!requestedFile.exists()){
                requestedFile.createNewFile();
            }
            System.out.println(eventFile.getPath());
            ObjectInputStream oos = new ObjectInputStream(new FileInputStream(eventFile));
            events = (ArrayList<Event>) oos.readObject();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(requestedFile));
            requestedEvents = (ArrayList<Event>) ois.readObject();
            ois.close();
            oos.close();
        }
        catch (Exception e){
            System.out.println("Error given load data");
        }
    }
    //    load data end
//    delete data start
    public void deleteData(){
        events.clear();
        requestedEvents.clear();
        if(eventFile.exists()){
            try{
                eventFile.delete();
                eventFile.createNewFile();
            }
            catch (Exception e){
                System.out.println("Error given delete data");
            }
        }
        if(requestedFile.exists()){
            try {
                requestedFile.delete();
                requestedFile.createNewFile();
            }
            catch (Exception e){
                System.out.println("Error given delete data");
            }
        }
    }
//    delete data end
}