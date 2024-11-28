import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatMockTest {
    @Mock
    private Feline feline;
    private Cat cat;
    private final List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");

    @Before
    public void setUpCat() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);
        cat = new Cat(feline);
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> actualFood = cat.getFood();
        Assert.assertEquals(expectedFood, actualFood);
    }

    @Test
    public void getSoundTest() {
        String actualSound = cat.getSound();
        Assert.assertEquals("Мяу", actualSound);
    }
}
