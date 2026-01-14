import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorSolutionTest {

    RockPaperScissor rock = new RockPaperScissor();

    @Test
    void testRunWin(){
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("Derek").thenReturn("1").thenReturn("2").thenReturn("5").thenReturn("5");
        rock.setScanner(mockScanner);
        Random mockRandom = mock(Random.class);
        when(mockScanner.nextInt()).thenReturn(0);
        rock.setRandom(mockRandom);
        rock.run();
        assertEquals("Derek wins and beat the computer's Rock", rock.getOutput().get(3));
    }
    
}
