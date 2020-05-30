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
        Flight flightToAddToPassenger = new Flight(this.plane, this.flightNumber, this.destinationAirport, this.departureAirport,this.departureTime);
        passenger.setFlight(flightToAddToPassenger);
        passenger.setSeatNumber(this.generateNotUsedSeat());
        }
    }



    public void removePassenger(){
        this.passengers.remove(0);
    }

    public boolean checkAvailableSeat() {
        return (this.plane.getPlaneType().getCapacity() > this.countPassenger());
    }

    public boolean checkIfPassengerIsAlreadyInThePassengerList(Passenger passenger) {
        return this.passengers.indexOf(passenger) >= 0;
    }
    public int generateRandomSeatNumber(){
        if(this.getPlane().getPlaneType().getCapacity() == 1){
            return 1;
        }else{
        int randomSeat = (int) (this.getPlane().getPlaneType().getCapacity() * Math.random());
        return randomSeat;
    }
    }
    public boolean isSeatNumberAlreadyOccupied(int randomNumber){
        for(Passenger passenger : this.passengers){
            return passenger.getSeatNumber() == randomNumber;
        }
        return false;
    }
    public int generateNotUsedSeat() {
        int randomSeat = this.generateRandomSeatNumber();
        while (this.isSeatNumberAlreadyOccupied(randomSeat) && randomSeat > 0) {
            randomSeat = this.generateRandomSeatNumber();}
            return randomSeat;
    }

    public Passenger getPassengerAtIndex(int index) {
        return this.passengers.get(index);
    }

}
