public class FlightManager {

    private Flight flight;

    public FlightManager(Flight flight){
        this.flight = flight;
    }

    public double availableBaggageWeightForPlane(){
        double allowedWeight = this.flight.getPlane().getPlaneType().getTotalWeight()/2;
        return allowedWeight;
    }
    public double oneBaggageWeight(){

        double baggageWeightParPassenger = this.availableBaggageWeightForPlane() / this.flight.getPlane().getPlaneType().getCapacity();
        return baggageWeightParPassenger; //each baggage is 7.5 kg for the concorde
    }

    public double totalBaggageWeighParFlight() {
        double total = 0.00;
        for( Passenger passenger : this.flight.getPassengers()){
            total += (passenger.getBags()*this.oneBaggageWeight());
        }
        return total;
    }
}
