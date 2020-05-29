import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PassengerTest {
    Passenger passenger;

    @Before
    public void setUp(){
        passenger = new Passenger("Giovanni", 3);
    }
    @Test
    public void hasAName(){
        assertEquals("Giovanni", passenger.getName());
    }
    @Test
    public void hasBags(){
        assertEquals(3, passenger.getBags());
    }

    @Test
    public void checkIfPassengerHasFlight__doNotHave() {
        assertFalse(passenger.hasFlight());

    }
}
