import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestFeline {


    @Test
    public void testEatMeatRealLogic() throws Exception {
        Feline feline = new Feline();
        List<String> actualResult = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actualResult);
    }

    @Test
    public void testEatMeatSpy() throws Exception {
        Feline felineSpy = Mockito.spy(new Feline());
        Mockito.when(felineSpy.getFood("Хищник")).thenReturn(List.of("Птичка", "Рыбка"));
        List<String> actualResult = felineSpy.eatMeat();
        assertEquals(List.of("Птичка", "Рыбка"), actualResult);
        Mockito.verify(felineSpy).getFood("Хищник");
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensDefault() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }
}