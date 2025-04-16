package io.github.fontysvenlo.ais.restapi;



import io.javalin.http.Context;
import io.javalin.apibuilder.CrudHandler;

import io.github.fontysvenlo.ais.datarecords.FlightData;
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
        FlightData FlightData = context.bodyAsClass(FlightData.class);
        if (FlightData == null) {
            context.status(400);
            return;
        }
        context.status(201);
        context.json(FlightManager.add(FlightData));
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