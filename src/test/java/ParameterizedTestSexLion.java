import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class ParameterizedTestSexLion {

    private final String sex;
    private final boolean expectedLionHasMane;

    public ParameterizedTestSexLion(String sex, boolean expectedLionHasMane) {
        this.sex = sex;
        this.expectedLionHasMane = expectedLionHasMane;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false},
                {"Симба", false}
        });
    }

    @Test
    public void testLionHaveMane() throws Exception {
        Lion lion = new Lion(sex, new Feline());
        assertEquals(expectedLionHasMane, lion.doesHaveMane());
    }

}
