package io.github.fontysvenlo.ais.businesslogic;

import java.util.ArrayList;
import java.util.List;

class FlightSearch {
    private List<Flight> flights;

    public FlightSearch() {
        flights = new ArrayList<>();
        flights.add(new Flight("AA101", "New York", "Los Angeles", "10:00 AM"));
        flights.add(new Flight("CA303", "Amsterdam", "London", "3:45 PM"));
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