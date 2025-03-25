package io.github.fontysvenlo.ais.businesslogic.api;
public record Employee(
    String employeeID,
    String firstName,
    String lastName,
    String role,
    String email,
    String phoneNumber,
    String assignedFlightID
) { }