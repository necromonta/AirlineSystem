package io.github.fontysvenlo.ais.businesslogic;

import java.util.ArrayList;
import java.util.List;

class Flight {
    private String flightID;
    private String origin;
    private String destination;
    private String flightTime;

    public Flight(String flightID, String origin, String destination, String flightTime) {
        this.flightID = flightID;
        this.origin = origin;
        this.destination = destination;
        this.flightTime = flightTime;
    }

    public String getFlightID() {
        return flightID;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public String getFlightTime() {
        return flightTime;
    }

    @Override
    public String toString() {
        return "FlightID: " + flightID + ", Origin: " + origin + ", Destination: " + destination + ", Time: " + flightTime;
    }
}