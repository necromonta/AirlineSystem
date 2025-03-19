package io.github.fontysvenlo.ais.businesslogic;

import java.util.ArrayList;
import java.util.List;


public class SearchFlightImpl {
 private List<Flight> flights;

    public SearchFlightImpl() {
        flights = new ArrayList<>();
        flights.add(new Flight("AA101", "New York", "Los Angeles", "10:00 AM"));
        flights.add(new Flight("CA303", "Amsterdam", "London", "3:45 PM"));
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
}
