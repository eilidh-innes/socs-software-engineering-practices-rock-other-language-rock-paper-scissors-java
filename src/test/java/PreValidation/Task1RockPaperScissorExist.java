package PreValidation;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class Task1RockPaperScissorExist{
  final String file_name = "src/main/java/RockPaperScissor.java";
  File file = new File(file_name);
  JavaFile javaFile = new JavaFile(file);

  @Test
  void fileExists() {
    assertTrue(file.isFile());
  }

  @Test
  void determineWinnerReturnsString(){
    assertEquals(javaFile.getMethodByName("determineWinner").getReturnType(),"String");
  }

  @Test
  void determineWinnerHasCorrectParameters(){
    List<String> correctParams = new ArrayList<String>();
    correctParams.add("String");
    correctParams.add("int");
    correctParams.add("int");
    correctParams.add("String");
    assertEquals(correctParams, javaFile.getMethodByName("determineWinner").getInputParameterType());
  }

}