package io.github.fontysvenlo.ais.businesslogic.api;

import java.util.List;

public interface SearchFlight {
    
    List<Flight> searchFlights(String origin, String destination);
    
}
