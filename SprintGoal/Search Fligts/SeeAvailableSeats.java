package javaapplication20;

import java.util.ArrayList;
import java.util.List;

class Seat {
    private String seatNumber;
    private boolean isAvailable;
    
    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
        this.isAvailable = true;
    }
    
    public String getSeatNumber() {
        return seatNumber;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    public void assignSeat() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Seat " + seatNumber + " assigned successfully.");
        } else {
            System.out.println("Seat " + seatNumber + " is already taken.");
        }
    }
}

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


class SalesEmployee {
    private String name;
    
    public SalesEmployee(String name) {
        this.name = name;
    }
    
    public void assignSeat(Flight flight, String seatNumber) {
        System.out.println(name + " is assigning seat " + seatNumber);
        flight.assignSeat(seatNumber);
    }
}

public class SeeAvailableSeats {
    public static void main(String[] args) {
        Flight flight = new Flight("FL123", 5); 
        SalesEmployee employee = new SalesEmployee("John");
        
        flight.displayAvailableSeats();
        employee.assignSeat(flight, "3C"); 
        flight.displayAvailableSeats(); 
    }
}

