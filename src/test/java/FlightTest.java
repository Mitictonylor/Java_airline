import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Flight flight;
    Plane plane;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Passenger passenger4;

    @Before
    public void setUp(){
        passenger1 = new Passenger("Giovanni", 3);
        passenger2 = new Passenger("PierGiorgio", 2);
        passenger3 = new Passenger("Eustachio", 1);
        passenger4 = new Passenger("Ciccillo", 5);
        plane = new Plane(PlaneType.BOEING);
        flight = new Flight(plane,"a1010","BRI","GLA","18:00");
    }
    @Test
    public void theFlightStartWithNoPassenger(){
        assertEquals(0, flight.countPassenger());
    }
    @Test
    public void weCanAddPassenger(){
        flight.addPassenger(passenger1);
        assertEquals(1, flight.countPassenger());
    }



}
