import com.example.Alex;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestAlex {

    private Alex alex;

    @Before
    public void setUp() throws Exception {
        Feline feline = new Feline();
        alex = new Alex(feline);
    }

    @Test
    public void testGetKittensZero() {
        assertEquals(0, alex.getKittens());
    }

    @Test
    public void testGetFriends() {
        List<String> expectedFriends = List.of("зебра Марти","бегемотиха Глория"," жираф Мелман");
        assertEquals(expectedFriends, alex.getFriends());
    }

    @Test
    public void testGetPlaceOfLiving() {
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void testAlexIsLionSubclass() {
        assertTrue(alex instanceof com.example.Lion);
    }
}