import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CalcTests {
    @Test
    public void canAdd(){
        assertEquals(2,
                Calculator.calculate(1, 1, Double::sum), "Integers" );
        assertEquals(3,
                Calculator.calculate(2.0, 1, Double::sum), "Double & Int" );
        assertEquals(15.00,
                Calculator.calculate(7.0, 8.0, Double::sum), "Doubles" );
        assertEquals(5,
                Calculator.calculate(6, -1, Double::sum), "negative" );
        assertEquals(-2,
                Calculator.calculate(6, -8, Double::sum), "negative" );
    }

    @Test
    public void canSubtract(){
        assertEquals(0,
                Calculator.calculate(1, 1, (a, b) -> a - b), "Integers" );
        assertEquals(1,
                Calculator.calculate(2.0, 1, (a, b) -> a - b), "Double & Int" );
        assertEquals(-1,
                Calculator.calculate(7.0, 8.0, (a, b) -> a - b), "Doubles" );
        assertEquals(7,
                Calculator.calculate(6, -1, (a, b) -> a - b), "negative" );
    }
}
