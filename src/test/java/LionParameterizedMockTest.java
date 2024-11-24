import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.List;

@RunWith(Parameterized.class)
public class LionParameterizedMockTest {

    private final int kittensCount;
    private final String sex;
    private final List<String> food;
    private final boolean haveMane;

    public LionParameterizedMockTest(int kittensCount, String sex, List<String> food, boolean haveMane) {
        this.kittensCount = kittensCount;
        this.sex = sex;
        this.food = food;
        this.haveMane = haveMane;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {0, "Самец", List.of("Животные", "Птицы", "Рыба"), true},
                {1, "Самка", List.of("Животные", "Птицы"), false}
        };
    }

    @Test
    public void lionWithFelineMockTest() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Mockito.when(feline.getKittens()).thenReturn(kittensCount);
        Mockito.when(feline.getFood(Mockito.eq("Хищник"))).thenReturn(food);
        Lion lion = new Lion(feline, sex);
        int actualKittens = lion.getKittens();
        List<String> actualFood = lion.getFood();
        boolean actualHaveMane = lion.doesHaveMane();
        Assert.assertEquals("Количество котят не соответствует ожидаемому", kittensCount, actualKittens);
        Assert.assertEquals("Список еды не соответствует ожидаемому", food, actualFood);
        Assert.assertEquals("Наличие гривы не соответствует ожидаемому", haveMane, actualHaveMane);
    }
}
