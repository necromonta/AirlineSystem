package io.github.fontysvenlo.ais.restapi;



import io.javalin.http.Context;
import io.javalin.apibuilder.CrudHandler;

import io.github.fontysvenlo.ais.datarecords.FlightData;

import java.util.Map;

import io.github.fontysvenlo.ais.businesslogic.api.FlightManager;

/**
 * This class is responsible for handling the requests for the Flight resource.
 */
class FlightResource implements CrudHandler {
    final private FlightManager FlightManager;

    /**
     * Initializes the controller with the business logic.
     */
    FlightResource(FlightManager FlightManager) {
        this.FlightManager = FlightManager;
    }

    /**
     * Adds a Flight to the storage.
     * - If the Flight data is null, the status is set to 400 (Bad Request).
     * - Otherwise, the status is set to 201 (Created) and the added Flight is returned as JSON.
     */
    @Override
    public void create(Context context) {
        try {
            System.out.println("Request Body: " + context.body()); // Log the incoming JSON
            FlightData flightData = context.bodyAsClass(FlightData.class);
            if (flightData == null) {
                context.status(400).json(Map.of("error", "Invalid flight data"));
                return;
            }
            System.out.println("Flight Data: " + flightData); // Log the FlightData object
            context.status(201).json(FlightManager.add(flightData));
        } catch (Exception e) {
            e.printStackTrace(); // Log the error for debugging
            context.status(500).json(Map.of("error", "Internal server error"));
        }
    }


    /**
     * Retrieves all Flights from the storage.
     * - The status is set to 200 (OK) and the list of Flights is returned as JSON.
     */
    @Override
    public void getAll(Context context) {
        context.status(200);
        context.json(FlightManager.list());
    }

    @Override
    public void delete(Context context, String FlightId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void getOne(Context context, String FlightId) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void update(Context context, String FlightId) {
        throw new UnsupportedOperationException("Not implemented yet");

    }
}