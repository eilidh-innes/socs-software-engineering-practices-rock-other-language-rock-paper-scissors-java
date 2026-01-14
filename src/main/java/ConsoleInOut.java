import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInOut {

    private Scanner userInput = new Scanner(System.in);
    private List<String> output = new ArrayList<String>();

    public void setScanner(Scanner scanner){
        this.userInput = scanner;
    }

    public String getString(String message){
        display(message);
        return userInput.nextLine();
    }

    public void display(String message){
        output.add(message);
        System.out.println(message);
    }

    public List<String> getOutput(){
        return output;
    }
    
}
