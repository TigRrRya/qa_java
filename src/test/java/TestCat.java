import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class TestCat {
    private Feline feline;
    private Cat cat;

    @Before
    public void setUp() {
        feline = spy(new Feline());
        cat = new Cat(feline);
    }

    @Test
    public void testGetFoodCatRealLogic() throws Exception {
        List<String> actualCatFood = cat.getFood();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, actualCatFood);
    }

    @Test
    public void testGetFoodCatSpyStub() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы");
        doReturn(expectedFood).when(feline).eatMeat();
        List<String> actualCatFood = cat.getFood();
        assertEquals(expectedFood, actualCatFood);
        verify(feline).eatMeat();
    }

    @Test
    public void testGetSoundCat () {
        assertEquals("Мяу",cat.getSound());
    }
}