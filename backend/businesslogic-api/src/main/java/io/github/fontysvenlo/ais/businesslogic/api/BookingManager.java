package io.github.fontysvenlo.ais.businesslogic.api;

import java.util.Date;

public interface BookingManager {
    public void addBooking(String bookingID,
     String passengerID,
     String flightID,
     Date bookingDate,
    String status,
    double paymentAmount,
    String discountID);
    public void removeBooking();    
}
