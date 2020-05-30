import java.util.ArrayList;

public class FlightManager {

    private Flight flight;

    public FlightManager(Flight flight) {
        this.flight = flight;
    }

    public double availableBaggageWeightForPlane() {
        double allowedWeight = this.flight.getPlane().getPlaneType().getTotalWeight() / 2;
        return allowedWeight;
    }

    public double oneBaggageWeight() {

        double baggageWeightParPassenger = this.availableBaggageWeightForPlane() / this.flight.getPlane().getPlaneType().getCapacity();
        return baggageWeightParPassenger; //each baggage is 7.5 kg for the concorde
    }

    public double totalBaggageWeighParFlight() {
        double total = 0.00;
        for (Passenger passenger : this.flight.getPassengers()) {
            total += (passenger.getBags() * this.oneBaggageWeight());
        }
        return total;
    }

    public double leftOverWeightForBaggages() {
        double difference = this.availableBaggageWeightForPlane() - this.totalBaggageWeighParFlight();
        return difference;
    }

    public void sortPassengerListBySeatNumber(ArrayList<Passenger> passengers) {
        int i, j = 0;
        Passenger temp;
        for (i = 0; i < passengers.size() - 1; i++) {
            for (j = 0; j < passengers.size() - 1 - i; j++) {
                if (passengers.get(j).getSeatNumber() > passengers.get(j + 1).getSeatNumber()) {
                    temp = passengers.get(j);
                    passengers.set(j, this.flight.getPassengerAtIndex(j + 1));
                    passengers.set(j + 1, temp);
                }
            }
        }
    }

    //need to sort the list before using this
    public Passenger findAPassengerWithBinarySearch(ArrayList<Passenger> passengers, int searchSeatNumber) {
        int middleIndex = 0;
        if (passengers.size() > 0) {
            middleIndex = (int) Math.ceil(passengers.size() / 2);
        }
            Passenger middlePerson = passengers.get(middleIndex);
            if (middlePerson.getSeatNumber() == searchSeatNumber) {
                return middlePerson;
            }
            ArrayList<Passenger> newSearchArea;
            if (searchSeatNumber < middlePerson.getSeatNumber()) {
                newSearchArea = new ArrayList<Passenger>(passengers.subList(0, middleIndex));
            } else {
                newSearchArea = new ArrayList<Passenger>(passengers.subList((middleIndex + 1), passengers.size()));
            }
            return this.findAPassengerWithBinarySearch(newSearchArea, searchSeatNumber);
        }

        public Passenger sortAndFindPassengerBySeatNumber(ArrayList<Passenger> passengers, int seatNumber){
         this.sortPassengerListBySeatNumber(passengers);
         return this.findAPassengerWithBinarySearch(passengers, seatNumber);
        }
    }


