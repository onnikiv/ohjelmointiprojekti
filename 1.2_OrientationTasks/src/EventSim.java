import java.util.PriorityQueue;

// Luokka Eventeille, 
class Event implements Comparable<Event> {
    private final String name;  
    private final long eventTime; 
    private final EventType eventType; // Arrive, Exit

    // alustetaan eventti, nimellä, ajalla ja tyypillä
    public Event(String name, long eventTime, EventType eventType) {
        this.name = name;
        this.eventTime = eventTime;
        this.eventType = eventType;
    }

    public long getEventTime() {
        return eventTime;
    }

    public String getName() {
        return name;
    }

    public EventType getEventType() {
        return eventType;
    }

    // verrataan nykyisen Eventin ja toisen eventin aikaväliä
    @Override
    public int compareTo(Event other) {
        return Long.compare(this.eventTime, other.eventTime);
    }
}
// Eventlist luokka, pidetään 
// EventList class manages a collection of events using a PriorityQueue
class EventList {
    private PriorityQueue<Event> events;  // PriorityQueue automatically orders events by their time

    // Alustus PriorityQueuelle
    public EventList() {
        events = new PriorityQueue<>();
    }

    // metodi lisätä eventti olio, events listaan
    public void addEvent(Event event) {
        events.add(event);
    }

    // metodi ottaa seuraava Eventti, palauttaa events listan ekan ja poistaa sen samalla
    public Event getNextEvent() {
        return events.poll();
    }

    // metodi tsekkaa onko listassa mitään
    public boolean hasMoreEvents() {
        return !events.isEmpty();
    }

    // metodi printtaa eventit ajanmukaan
    public void printEvents() {
        PriorityQueue<Event> copy = new PriorityQueue<>(events);  // luodaan kopio event listasta, jottei sitä tule muokattua vahingossa
        while (!copy.isEmpty()) {
            Event event = copy.poll();  // nappaa ja poista seuraava eventti copy listasta
            System.out.println("Event: " + event.getName() + ", Time: " + event.getEventTime() + ", Type: " + event.getEventType());
        }
    }
}

// Simulointi
public class EventSim {
    public static void main(String[] args) {
        EventList eventList = new EventList();  // eventti lista

        // eventit, esim Event 1 tapahtuu ajankohdalla 10, tapahtuma: Saapuminen, jne
        eventList.addEvent(new Event("Event 1", 10, EventType.ARRIVAL));
        eventList.addEvent(new Event("Event 2", 50, EventType.EXIT));
        eventList.addEvent(new Event("Event 3", 150, EventType.ARRIVAL));
        eventList.addEvent(new Event("Event 4", 75, EventType.EXIT));

        // printataan nimen mukaan
        System.out.println("Events in the list:");
        eventList.printEvents();

        // napataan ja "suoritetaan" seuraava eventti, joka on ajanmukaan eka
        Event nextEvent = eventList.getNextEvent();
        System.out.println("\nNext event to be processed: " + nextEvent.getName() + ", Time: " + nextEvent.getEventTime() + ", Type: " + nextEvent.getEventType());

        // printataan lista tapahtumista sen jälkeen, kun aikaisin tapahtuma on käsitelty ja poistettu
        System.out.println("\nEvents in the list after removing the first event:");
        eventList.printEvents();
    }
}
