import com.example.Animal;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FelineTest {

    Feline feline = new Feline();

    @Test
    public void getFamilyTest() {
        String actualFamily = feline.getFamily();
        Assert.assertEquals("Кошачьи", actualFamily);
    }

    @Test
    public void eatMeatTest() throws Exception {
        List<String> actualEatMeat = feline.eatMeat();
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), actualEatMeat);
    }

    @Test
    public void getFoodGrassTest() throws Exception {
        List<String> actualFood = feline.getFood("Травоядное");
        List<String> expectedFood = List.of("Трава", "Различные растения");
        Assert.assertEquals(expectedFood, actualFood);
    }

    @Test
    public void getFoodPredatorTest() throws Exception {
        List<String> actualFood = feline.getFood("Хищник");
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expectedFood, actualFood);
    }

    @Test(expected = Exception.class)
    public void getUnknownAnimalTest() throws Exception {
        feline.getFood("Неизвестный вид животного");
    }

    @Test
    public void getKittensTest() {
        int actualKittens = feline.getKittens();
        Assert.assertEquals(1, actualKittens);
    }

    @Test
    public void getKittensOneTest() {
        int actualKittensCount = feline.getKittens(1);
        int expectedKittensCount = 1;
        Assert.assertEquals(expectedKittensCount, actualKittensCount);
    }

    @Test
    public void getKittensTwoTest() {
        int actualKittensCount = feline.getKittens(2);
        int expectedKittensCount = 2;
        Assert.assertEquals(expectedKittensCount, actualKittensCount);
    }
}
