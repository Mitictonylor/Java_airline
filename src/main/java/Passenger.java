public class Passenger {
    private String name;
    private int numberOfBags;
    private Flight flight;
    private int seatNumber;

    public Passenger(String name, int numberOfBags){
        this.name = name;
        this.numberOfBags = numberOfBags;
        this.seatNumber = seatNumber;
        this.flight = flight;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String getName() {
        return this.name;
    }

    public int getBags() {
        return this.numberOfBags;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public boolean hasFlight() {
        return this.flight != null;
    }
    public boolean hasSeatNumber() {
        return this.seatNumber >= 0;
    }
}
