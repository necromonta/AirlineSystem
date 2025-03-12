package io.github.fontysvenlo.ais.businesslogic;

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