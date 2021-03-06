import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class FlightManagerTest {

    Flight flight;
    Plane plane;
    FlightManager flightManager;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Passenger passenger4;

    @Before
    public void setUp() {
        passenger1 = new Passenger("Giovanni", 2);
        passenger2 = new Passenger("PierGiorgio", 1);
        passenger3 = new Passenger("Paul", 3);
        passenger4 = new Passenger("Francis", 5);
        plane = new Plane(PlaneType.CONCORDE);
        flight = new Flight(plane,"a1010","BRI","GLA","18:00");
        flightManager = new FlightManager(flight);
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);
        flight.addPassenger(passenger3);
    }
    @Test
    public void getAllowedBaggageWeightParPlane() {
        assertEquals(1500.00, flightManager.availableBaggageWeightForPlane(),0.01);
    }

    @Test
    public void getAllowedBaggageWeightParPassenger() {
        assertEquals(7.5, flightManager.oneBaggageWeight(),0.01);
    }

    @Test
    public void getTotalBaggageWeightParFlight() {
    assertEquals(45.00, flightManager.totalBaggageWeighParFlight(), 0.01);
    }

    @Test
    public void getLeftBaggageWeighParFlight() {
        assertEquals(1455.00, flightManager.leftOverWeightForBaggages(), 0.01);
    }
}
