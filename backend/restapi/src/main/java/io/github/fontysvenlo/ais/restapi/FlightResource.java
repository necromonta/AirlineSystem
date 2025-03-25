package io.github.fontysvenlo.ais.restapi;

import io.javalin.http.Context;
import io.javalin.apibuilder.EndpointGroup;
import io.github.fontysvenlo.ais.businesslogic.Flight;
import io.github.fontysvenlo.ais.businesslogic.FlightSearch;

import java.util.List;

import static io.javalin.apibuilder.ApiBuilder.*;

public class FlightResource {

    private final FlightSearch flightSearch = new FlightSearch();

    public EndpointGroup routes() {
        return () -> {
            get("flights", this::handleGetAllFlights);
            get("flights/search", this::handleSearchFlights);
            post("flights", this::handleCreateFlight);
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

    private void handleGetAllFlights(Context ctx) {
        ctx.status(200).json(flightSearch.getAllFlights());
    }
}
