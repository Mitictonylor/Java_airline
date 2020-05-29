import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {
    private Plane plane;

    @Before
    public void setUp(){
        plane = new Plane(PlaneType.BOEING);
    }
    @Test
    public void canGetPlaneType(){
        assertEquals(PlaneType.BOEING, plane.getPlaneType() );
    }
    @Test
    public void canGetPlaneCapacity(){
        assertEquals(300, plane.getPlaneType().getCapacity());
    }

}
