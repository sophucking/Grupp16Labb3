import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import Model.Vehicles.Saab95;

public class Saab95Test {
    Saab95 testSaab;

    @Before
    public void init() {
        testSaab = new Saab95();
        testSaab.startEngine();
    }

    @Test
    public void testTurbo() {
        // turbo off 
        testSaab.gas(1);
        double gasWoTurbo = testSaab.getCurrentSpeed();
        testSaab.setTurboOn();
        testSaab.gas(1);
        double gasWithTurbo = testSaab.getCurrentSpeed();
        assertTrue(gasWithTurbo - gasWoTurbo > gasWoTurbo);
    }
}
