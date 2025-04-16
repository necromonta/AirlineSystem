package io.github.fontysvenlo.ais.persistence.api;


import io.github.fontysvenlo.ais.datarecords.FlightData;

import java.util.List;

/**
 * Interface that describes all services offered by the CustomerRepository.
 */
public interface FlightRepository {
    /**
     * Adds a customer to the storage.
     * @param customerData the customer to add
     * @return the added customer
     */
     FlightData add( FlightData flightData);

    /**
     * Retrieves all customers from the storage.
     * @return a list of all flights
     */
     List<FlightData> getAll();
}