package io.github.fontysvenlo.ais.datarecords;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;



public record FlightData(Integer id, String origin, String destination, 
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")LocalDate departureDate) {
}

