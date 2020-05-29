public class Passenger {
    private String name;
    private int numberOfBags;
//    private Flight flight;
    private int seatNumber;

    public Passenger(String name, int numberOfBags){
        this.name = name;
        this.numberOfBags = numberOfBags;
        this.seatNumber = seatNumber;
    }

    public String getName() {
        return this.name;
    }

    public int getBags() {
        return this.numberOfBags;
    }
}
