package io.github.fontysvenlo.ais.datarecords;

import java.time.LocalDate;

public record FlightData(Integer id, String origin, String destination,LocalDate departureDate) {
 }

