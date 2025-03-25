package io.github.fontysvenlo.ais.businesslogic;

import java.util.ArrayList;
import java.util.List;

 public class Flight {
    private String flightID;
    private String origin;
    private String destination;
    private String flightTime;

    public Flight() {} // I need this for JSON object mapping

    public Flight(String flightID, String origin, String destination, String flightTime) {
        this.flightID = flightID;
        this.origin = origin;
        this.destination = destination;
        this.flightTime = flightTime;
    }

     public String getFlightID() {
         return flightID;
     }

     public void setFlightID(String flightID) {
         this.flightID = flightID;
     }

     public String getOrigin() {
         return origin;
     }

     public void setOrigin(String origin) {
         this.origin = origin;
     }

     public String getDestination() {
         return destination;
     }

     public void setDestination(String destination) {
         this.destination = destination;
     }

     public String getFlightTime() {
         return flightTime;
     }

     public void setFlightTime(String flightTime) {
         this.flightTime = flightTime;
     }

     @Override
     public String toString() {
         return "FlightID: " + flightID + ", Origin: " + origin + ", Destination: " + destination + ", Time: " + flightTime;
     }
}