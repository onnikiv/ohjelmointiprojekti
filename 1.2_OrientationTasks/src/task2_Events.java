import java.util.PriorityQueue;

class Event implements Comparable<Event> {
    private final String name;
    private final long eventTime;

    public Event(String name, long eventTime) {
        this.name = name;
        this.eventTime = eventTime;
    }

    public long getEventTime() {
        return eventTime;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Event other) {
        return Long.compare(this.eventTime, other.eventTime);
    }
}

class EventList {
    private final PriorityQueue<Event> events;

    public EventList() {
        events = new PriorityQueue<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public Event getNextEvent() {
        return events.poll();
    }

    public boolean hasMoreEvents() {
        return !events.isEmpty();
    }

    public void printEvents() {
        PriorityQueue<Event> copy = new PriorityQueue<>(events);
        while (!copy.isEmpty()) {
            Event event = copy.poll();
            System.out.println("Event: " + event.getName() + ", Time: " + event.getEventTime());
        }
    }
}

public class task2_Events {
    public static void main(String[] args) {
        EventList eventList = new EventList();

        // Generate a list of events
        eventList.addEvent(new Event("Event 1", 1000));
        eventList.addEvent(new Event("Event 2", 500));
        eventList.addEvent(new Event("Event 3", 1500));
        eventList.addEvent(new Event("Event 4", 750));

        // Print the contents of the EventList
        System.out.println("Events in the list:");
        eventList.printEvents();

        // Remove the first event
        Event nextEvent = eventList.getNextEvent();
        System.out.println("\nNext event to be processed: " + nextEvent.getName() + ", Time: " + nextEvent.getEventTime());

        // Print the contents of the EventList after removing the first event
        System.out.println("\nEvents in the list after removing the first event:");
        eventList.printEvents();
    }
}