import static org.junit.Assert.*;
import org.junit.*;

import Vehicles.ScaniaV8;

public class ScaniaV8Test {

    ScaniaV8<Object> testTSP;

    @Before
    public void init() {
        this.testTSP = new ScaniaV8<>();
        this.testTSP.startEngine();
    }

     @Test
    public void lowerAndHeightenStorage() {
        testTSP.raiseStorage(70);
        testTSP.lowerStorage(35);
        assertEquals(35, testTSP.getStorageAngle(), 0.01);
        testTSP.lowerStorage(35);
        assertNotEquals(35, testTSP.getStorageAngle(), 0.01);
        testTSP.lowerStorage(80);
        assertEquals(0, testTSP.getStorageAngle(), 0.01);
        testTSP.raiseStorage(70);
        assertEquals(70, testTSP.getStorageAngle(), 0.01);
        testTSP.lowerStorage(70);
        testTSP.gas(1);
        testTSP.raiseStorage(70);
        assertNotEquals(70, testTSP.getStorageAngle(), 0.01);
        testTSP.brake(1);
        testTSP.raiseStorage(80);
        assertEquals(70, testTSP.getStorageAngle(), 0.01);
    }

    @Test
    public void noGasWhenStorageIsUp (){
        testTSP.raiseStorage(70);
        testTSP.gas(1);
        assertEquals(0, testTSP.getCurrentSpeed(), 0.01);
    }
}
