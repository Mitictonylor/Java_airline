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

    public double leftOverWeightForBaggages() {
        double difference = this.availableBaggageWeightForPlane() - this.totalBaggageWeighParFlight();
        return difference;
    }
    public void sortPassengerListBySeatNumber(){
        int i,j = 0;
        Passenger temp;
        for (i=0; i<this.flight.countPassenger() - 1; i++){
            for (j=0; j <this.flight.countPassenger() -1 - i; j++){
                if(this.flight.getPassengerAtIndex(j).getSeatNumber() > flight.getPassengerAtIndex(j+1).getSeatNumber()){
                    temp = this.flight.getPassengerAtIndex(j);
                    this.flight.getPassengers().set(j, this.flight.getPassengerAtIndex(j+1));
                    this.flight.getPassengers().set(j+1, temp);
                }
            }
        }
    }
}
