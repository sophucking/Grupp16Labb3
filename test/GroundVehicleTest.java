import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.geom.Point2D;

import org.junit.Before;
import org.junit.Test;

public class GroundVehicleTest {

    GroundVehicle testGroundVehicle;

    @Before
    public void init() {
        testGroundVehicle = new Volvo240();
        testGroundVehicle.startEngine();
    }
    
    @Test
    public void testIsEngineOn() {
        assertTrue(testGroundVehicle.isEngineOn());
        testGroundVehicle.stopEngine();
        assertFalse(testGroundVehicle.isEngineOn());
    }

    @Test
    public void testBrake() {
        testGroundVehicle.gas(1);
        double initSpeed = testGroundVehicle.getCurrentSpeed();
        testGroundVehicle.brake(0.5);
        assertTrue(initSpeed > testGroundVehicle.getCurrentSpeed());
    }

    @Test
    public void testGas() {
        double initSpeed = testGroundVehicle.getCurrentSpeed();
        testGroundVehicle.gas(0.5);
        assertTrue(initSpeed < testGroundVehicle.getCurrentSpeed());
    }

    @Test
    public void testGetColor() {
        assertNotNull(testGroundVehicle.getColor());
    }

    @Test
    public void testGetCurrentSpeed() {
        assertTrue(0 <= testGroundVehicle.getCurrentSpeed()
            && testGroundVehicle.getCurrentSpeed() <= testGroundVehicle.getEnginePower());
    }

    @Test
    public void testGetDirection() {
        assertTrue(Double.isFinite(testGroundVehicle.getDirection()));
    }

    @Test
    public void testGetEnginePower() {
        assertTrue(testGroundVehicle.getEnginePower() > 0);
    }

    @Test
    public void testGetNrDoors() {
        int nrDoors = testGroundVehicle.getNrDoors();
        assertTrue(nrDoors == 2 || nrDoors == 4);
    }

    @Test
    public void testGetPosition() {
        assertNotNull(testGroundVehicle.getPosition());
    }

    @Test
    public void testMove() {
        Point2D.Double initial = testGroundVehicle.getPosition();
        testGroundVehicle.gas(1);
        testGroundVehicle.move();
        assertNotEquals(initial, testGroundVehicle.getPosition());
    }

    @Test
    public void testSetColor() {
        Color initColour = testGroundVehicle.getColor();
        testGroundVehicle.setColor(initColour.brighter());
        assertNotEquals(initColour, testGroundVehicle.getColor());
    }

    @Test
    public void testStartEngine() {
        assertTrue(testGroundVehicle.isEngineOn());
    }

    @Test
    public void testStopEngine() {
        testGroundVehicle.stopEngine();
        assertFalse(testGroundVehicle.isEngineOn());
    }

    @Test
    public void testTurnLeft() {
        double initDir = testGroundVehicle.getDirection();
        testGroundVehicle.turnLeft(1.5);
        assertTrue(initDir < testGroundVehicle.getDirection());
    }

    @Test
    public void testTurnRight() {
        double initDir = testGroundVehicle.getDirection();
        testGroundVehicle.turnRight(1.5);
        assertTrue(initDir > testGroundVehicle.getDirection());
    }

    @Test
    public void throwGasBrakeThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    testGroundVehicle.gas(2);
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    testGroundVehicle.gas(-2);
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    testGroundVehicle.brake(2);
                });
        assertThrows(IllegalArgumentException.class,
                () -> {
                    testGroundVehicle.brake(-2);
                });
    }

    @Test
    public void ensureCurrentSpeedAllowedValue() {
        for (int i = 0; i < 100; i++) {
            testGroundVehicle.brake(1);
        }
        assertTrue(testGroundVehicle.getCurrentSpeed() >= 0);

        for (int i = 0; i < 100; i++) {
            testGroundVehicle.gas(1);
        }
        assertTrue(testGroundVehicle.getCurrentSpeed() <= testGroundVehicle.getEnginePower());
    }

}
