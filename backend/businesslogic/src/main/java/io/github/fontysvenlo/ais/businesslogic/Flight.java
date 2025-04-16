package io.github.fontysvenlo.ais.businesslogic;


import io.github.fontysvenlo.ais.datarecords.FlightData;

/**
 * Wrapper class that contains FlightData and Flight Business Logic.
 */
public class Flight {

    private FlightData flightData;

    /**
     * Constructor
     * @param flightData the flight data
     */
    public Flight(FlightData flightData) {
        if (flightData.origin().isBlank() || flightData.origin().length() < 2) {
            throw new IllegalArgumentException("Flight origin is not allowed to be empty or less than 2 characters");
        }
        this.flightData = flightData;
    }

    // Write Flight Business Logic (methods) here
    // Changes to FlightData would mean creation of a new FlightData
    // object and replace the existing object.


}


