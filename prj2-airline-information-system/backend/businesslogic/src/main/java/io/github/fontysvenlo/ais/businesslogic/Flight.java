package io.github.fontysvenlo.ais.businesslogic;

import java.util.ArrayList;
import java.util.List;

class Flight {
    private String flightNumber;
    private List<Seat> seats;
    
    public Flight(String flightNumber, int seatRows) {
        this.flightNumber = flightNumber;
        this.seats = new ArrayList<>();
        char[] seatLetters = {'A', 'B', 'C', 'D', 'E', 'F'};
        for (int row = 1; row <= seatRows; row++) {
            for (char letter : seatLetters) {
                seats.add(new Seat(row + String.valueOf(letter)));
            }
        }
    }
    
    public void displayAvailableSeats() {
        System.out.println("Available seats on flight " + flightNumber + ":");
        for (Seat seat : seats) {
            if (seat.isAvailable()) {
                System.out.print(seat.getSeatNumber() + " ");
            }
        }
        System.out.println();
    }
    
    public void assignSeat(String seatNumber) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                seat.assignSeat();
                return;
            }
        }
        System.out.println("Seat " + seatNumber + " not found.");
    }
}