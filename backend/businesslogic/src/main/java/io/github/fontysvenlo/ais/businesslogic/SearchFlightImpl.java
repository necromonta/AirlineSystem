package io.github.fontysvenlo.ais.businesslogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

<<<<<<<< HEAD:backend/businesslogic/src/main/java/io/github/fontysvenlo/ais/businesslogic/FlightSearch.java
public  class FlightSearch {
    private List<Flight> flights;
========
import io.github.fontysvenlo.ais.businesslogic.api.Flight;
>>>>>>>> a9cd00ff4cb12718c7e17690ffbf6045620490c4:backend/businesslogic/src/main/java/io/github/fontysvenlo/ais/businesslogic/SearchFlightImpl.java


public class SearchFlightImpl {
 private List<Flight> flights;

    public SearchFlightImpl() {
        flights = new ArrayList<>();
        flights.add(new Flight("AA101", "New York", "Los Angeles", "10:00 AM"));
        flights.add(new Flight("CA303", "Amsterdam", "London", "3:45 PM"));
        flights.add(new Flight("BC423", "Bucharest", "Chisinau", "00:45 PM"));
    }

    public List<Flight> searchFlights(String origin, String destination) {
        List<Flight> results = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getOrigin().equalsIgnoreCase(origin) && flight.getDestination().equalsIgnoreCase(destination)) {
                results.add(flight);
            }
        }
        return results;
    }
<<<<<<<< HEAD:backend/businesslogic/src/main/java/io/github/fontysvenlo/ais/businesslogic/FlightSearch.java
     public void addFlight(Flight flight) {
         flights.add(flight);
     }

     public List<Flight> getAllFlights() {
         return new ArrayList<>(flights);
     }
    public Flight getFlightById(String flightID) {
        // Ensure you're correctly finding the flight by its ID
        return flights.stream()
                .filter(f -> f.getFlightID().equalsIgnoreCase(flightID))  // Case-insensitive match
                .findFirst()
                .orElse(null);  // Return null if flight is not found
    }

}
========
}
>>>>>>>> a9cd00ff4cb12718c7e17690ffbf6045620490c4:backend/businesslogic/src/main/java/io/github/fontysvenlo/ais/businesslogic/SearchFlightImpl.java
