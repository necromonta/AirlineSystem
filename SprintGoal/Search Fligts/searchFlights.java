import java.util.ArrayList;
import java.util.List;

class Flight {
    String flightNumber;
    String origin;
    String destination;
    String departureTime;

    public Flight(String flightNumber, String origin, String destination, String departureTime) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
    }

    @Override
    public String toString() {
        return "Flight " + flightNumber + " from " + origin + " to " + destination + " at " + departureTime;
    }
}

class FlightSearch {
    private List<Flight> flights;

    public FlightSearch() {
        flights = new ArrayList<>();
        flights.add(new Flight("AA101", "New York", "Los Angeles", "10:00 AM"));
        flights.add(new Flight("CA303", "Amsterdam", "London", "3:45 PM"));
        flights.add(new Flight("BA403", "Berlin", "Munich", "4:15 PM"));
        flights.add(new Flight("CI303", "Pisa", "Thessaloniki", "6:45 PM"));
        flights.add(new Flight("MA502", "Brussels Charleroi", "Pisa", "8:00 AM"));
    }

    public List<Flight> searchFlights(String origin, String destination) {
        List<Flight> results = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.origin.equalsIgnoreCase(origin) && flight.destination.equalsIgnoreCase(destination)) {
                results.add(flight);
            }
        }
        return results;
    }
}

public class AirlineTicketingSystem {
    public static void main(String[] args) {
        FlightSearch flightSearch = new FlightSearch();
        List<Flight> availableFlights = flightSearch.searchFlights("New York", "Los Angeles");
        
        if (availableFlights.isEmpty()) {
            System.out.println("No flights available.");
        } else {
            System.out.println("Available Flights:");
            for (Flight flight : availableFlights) {
                System.out.println(flight);
            }
        }
    }
}

