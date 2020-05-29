public class FlightManager {

    private Flight flight;

    public FlightManager(Flight flight){
        this.flight = flight;
    }

    public double baggageAllowedParFlight(){
        double availableBaggageWeightForPlane = this.flight.getPlane().getPlaneType().getTotalWeight()/2;
        double baggageWeightParPassenger = availableBaggageWeightForPlane / this.flight.getPlane().getPlaneType().getCapacity();
        return baggageWeightParPassenger; //each baggage is 7.5 kg for the concorde
    }

    public double totalBaggageWeighParFlight() {
        double total = 0.00;
        for( Passenger passenger : this.flight.getPassengers()){
            total += (passenger.getBags()*this.baggageAllowedParFlight());
        }
        return total;
    }
}
