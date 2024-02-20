import org.junit.Before;
import org.junit.Test;

import Vehicles.Truck;

import static org.junit.Assert.*;


import java.awt.*;
import java.awt.geom.Point2D;

public class TruckTest {

    private Truck<Integer> testTruck;
    @Before
    public void init() {
        testTruck =  new Truck<>(1,Color.GREEN,"dummy", 10);
    }

    @Test
    public void removeThingError() {
        assertThrows(IllegalAccessError.class, () -> {testTruck.removeThing();});
    }

    @Test
    public void gasWhenStorageOpen() {
        testTruck.openStorage();
        testTruck.gas(1);
        testTruck.move();
        assertEquals(new Point2D.Double(0,0), testTruck.getPosition());
    }
}
