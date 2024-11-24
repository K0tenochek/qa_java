import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.mockito.Mockito;

public class LionUnknownSexTest {
    @Test(expected = Exception.class)
    public void lionUnknownSex() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Lion lion = new Lion(feline, "детеныш");
    }
}
