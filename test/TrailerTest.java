import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

import Vehicles.*;

public class TrailerTest {
    Trailer<Integer> trailer;

    @Before
    public void init() {
        trailer = new Trailer<>(10);
    }

    @Test
    public void testStorageStatus() {
        assertFalse(trailer.isStorageOpen());
        trailer.openStorage();
        assertTrue(trailer.isStorageOpen());
        trailer.closeStorage();
        assertFalse(trailer.isStorageOpen());
    }

    @Test
    public void testStorageFunctions() {
        trailer.openStorage();
        Integer added = 1;
        trailer.storeThing(added);
        trailer.storeThing(2);
        trailer.storeThing(3);
        assertEquals(trailer.countThings(), 3);
        trailer.openStorage();
        Integer removed = trailer.removeThing();
        assertEquals(3, (long) removed);
        assertEquals(trailer.countThings(), 2);
        assertEquals(trailer.removeThing(), (Integer) 2);


        assertThrows(IllegalAccessError.class, () -> {
            trailer.closeStorage();
            trailer.removeThing();
        });
    }

    @Test
    public void maxCapacity() {

    }
}
