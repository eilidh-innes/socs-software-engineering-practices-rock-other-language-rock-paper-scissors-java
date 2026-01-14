import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Task2RockPaperScissorTest {

    @Test
    void testNewGame(){
        assertEquals(5,ReadConfig.getConfiguration().size() );
    }
    

}
