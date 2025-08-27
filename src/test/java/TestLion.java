import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestLion {


    private Feline feline;
    private Lion lion;

    @Before
    public void setUp() throws Exception {
        feline = spy(new Feline());
        lion = new Lion("Самец", feline);
    }

    @Test
    public void testLionHasMane() {
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testLionNotHaveMane() throws Exception {
        lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void testLionKittensDefaultRealLogic() {
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void testLionKittensMock() {
        doReturn(7).when(feline).getKittens();
        assertEquals(7, lion.getKittens());
        verify(feline).getKittens();
    }

    @Test
    public void testLionGetFoodRealLogic() throws Exception {
        List<String> actualCatFood = lion.getFood();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, actualCatFood);
    }

    @Test
    public void testLionGetFoodSpy() throws Exception {
        List<String> expectedFood = List.of("Рыбка", "Птичка");
        when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFoodLion = lion.getFood();
        assertEquals(expectedFood, actualFoodLion);
        verify(feline).getFood("Хищник");
    }
    @Test(expected = Exception.class)
    public void testInvalidSexThrowsException() throws Exception {
        new Lion("Неизвестный", new Feline());
    }

}