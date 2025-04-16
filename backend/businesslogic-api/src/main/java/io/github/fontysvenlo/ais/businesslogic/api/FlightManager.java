package io.github.fontysvenlo.ais.businesslogic.api;


import io.github.fontysvenlo.ais.datarecords.FlightData;

import java.util.List;
public interface FlightManager {


/**
 * Interface for objects that are able to manage Customers.


    /**
     * Add a customer.
     *
     * @param customerData the customer to add
     * @return the added customer data
     */
    public FlightData add(FlightData flightData);

    /**
     * Retrieve all customers.
     *
     * @return a list of all customers
     */
   
    public List<FlightData> list();



}
