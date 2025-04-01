package io.github.fontysvenlo.ais.businesslogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import io.github.fontysvenlo.ais.businesslogic.api.Flight;


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


