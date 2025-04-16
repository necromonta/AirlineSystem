package io.github.fontysvenlo.ais.businesslogic;


import io.github.fontysvenlo.ais.businesslogic.api.FlightManager;
import java.util.List;

import io.github.fontysvenlo.ais.datarecords.FlightData;
import io.github.fontysvenlo.ais.persistence.api.FlightRepository;



/**
 * Manages Flights in the business logic.
 * Linking pin between GUI and persistence. Connected to FlightRepository
 * in order to retrieve Flights and to persist changes.
 */
public class FlightManagerImpl implements FlightManager{

    private final FlightRepository flightRepository;
    /**
     * Constructor
     * @param FlightRepository the Flight storage service
     */
    public FlightManagerImpl( FlightRepository FlightRepository ) {
        this.flightRepository = FlightRepository;
    }

    /**
     * Adds a Flight to the storage.
     * @param FlightData the Flight to add
     * @return the added Flight data
     */
    @Override
    public FlightData add( FlightData FlightData ){
        // Validate
        Flight flight = new Flight(FlightData);
        return flightRepository.add(FlightData);
    }

    /**
     * Retrieves all Flights from the storage.
     * @return a list of all Flights
     */
    @Override
    public List<FlightData> list(){
        return flightRepository.getAll();
    }

}
