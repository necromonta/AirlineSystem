package io.github.fontysvenlo.ais.restapi;

import io.javalin.http.Context;
import io.javalin.apibuilder.EndpointGroup;
import io.github.fontysvenlo.ais.businesslogic.Flight;
import io.github.fontysvenlo.ais.businesslogic.FlightSearch;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static io.javalin.apibuilder.ApiBuilder.*;

public class FlightResource {

    private final FlightSearch flightSearch = new FlightSearch();

    public EndpointGroup routes() {
        return () -> {
            get("flights", this::handleGetAllFlights);
            get("flights/search", this::handleSearchFlights);
            post("flights", this::handleCreateFlight);
            get("flights/{flightID}", this::handleGetFlightById);
        };
    }

    private void handleSearchFlights(Context ctx) {
        String origin = ctx.queryParam("origin");
        String destination = ctx.queryParam("destination");

        if (origin == null || destination == null) {
            ctx.status(400).result("Missing origin or destination");
            return;
        }

        List<Flight> results = flightSearch.searchFlights(origin, destination);
        ctx.status(200).json(results);
    }

    private void handleCreateFlight(Context ctx) {
        Flight newFlight =  ctx.bodyAsClass(Flight.class);
        flightSearch.addFlight(newFlight);
        ctx.status(201).json(newFlight);
    }

    private final ObjectMapper mapper = new ObjectMapper();
    private void handleGetAllFlights(Context ctx) {
        try {
            List<Flight> flights = flightSearch.getAllFlights();

            // Log the fetched flight list
            System.out.println("Fetched flights: " + flights);

            if (flights == null || flights.isEmpty()) {
                ctx.status(404).result("No flights available");
                return;
            }

            // Return flights as JSON
            String json = mapper.writeValueAsString(flights);
            ctx.result(json).contentType("application/json");
        } catch (Exception e) {
            // Log the error for debugging
            e.printStackTrace();
            ctx.status(500).result("JSON serialization failed: " + e.getMessage());
        }
    }

    private void handleGetFlightById(Context ctx) {
        // Get the flightID from the URL
        String flightID = ctx.pathParam("flightID");
        System.out.println("Fetching flight with ID: " + flightID);

        // Search for the flight by flightID
        Flight flight = flightSearch.getFlightById(flightID);

        if (flight == null) {
            ctx.status(404).result("Flight not found");
        } else {
            // Return the found flight as JSON
            try {
                String json = mapper.writeValueAsString(flight);
                ctx.result(json).contentType("application/json");
            } catch (Exception e) {
                e.printStackTrace();
                ctx.status(500).result("Error serializing flight data");
            }
        }
    }
}