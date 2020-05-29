import java.util.ArrayList;

public class Flight {
    private ArrayList<Passenger> passengers;
    private Plane plane;
    private String flightNumber;
    private String destinationAirport;
    private String departureAirport;
    private String departureTime;

    public Flight(Plane plane, String flightNumber, String destinationAirport, String departureAirport, String departureTime) {
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destinationAirport = destinationAirport;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.passengers = new ArrayList<Passenger>();
    }

    public int countPassenger() {
        return this.passengers.size();
    }

    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }

    public Plane getPlane() {
        return this.plane;
    }

    public void addPassenger(Passenger passenger) {
     if( !this.checkIfPassengerIsAlreadyInThePassengerList(passenger) && this.checkAvailableSeat() ){
        this.passengers.add(passenger);
    }}

    public void removePassenger(){
        this.passengers.remove(0);
    }

    public boolean checkAvailableSeat() {
        return (this.plane.getPlaneType().getCapacity() > this.countPassenger());
    }

    public boolean checkIfPassengerIsAlreadyInThePassengerList(Passenger passenger) {
        return this.passengers.indexOf(passenger) >= 0;
    }
}
