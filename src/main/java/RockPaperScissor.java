import java.util.*;

class RockPaperScissor {

    private ConsoleInOut consoleInOut = new ConsoleInOut();
    private List<String> configuration;
    private final static String QUESTION_ENTER_INTEGER = "Please enter an integer";
    private final static String QUESTION_WHAT_IS_NAME = "Please enter your name";
    private final static String DEFAULT_NAME = "User"; 
    Random rand = new Random();

    RockPaperScissor(){
        configuration = ReadConfig.getConfiguration();
    }

    protected void setScanner(Scanner scanner){
        consoleInOut.setScanner(scanner);
    }

    protected void setRandom(Random rand){
        this.rand = rand;
    }

    protected List<String> getOutput(){
        return consoleInOut.getOutput();
    }

    private void display(String message){
        consoleInOut.display(message);
    }

    protected String getString(String message){
        return consoleInOut.getString(message);
    }

    protected int getInteger(String message) {
        int result = -1;
        int counter = 0;
        int maxCounter = 5;
        do {
            try {
                result = Integer.parseInt(getString(message));
            } catch (NumberFormatException exception) {
                // Display.Output expected NumberFormatException.
                display(QUESTION_ENTER_INTEGER);
            }
        } while (result < 0 && counter < maxCounter);

        return result;
    }


    private int getComputerChoice(){
        return rand.nextInt(3);
    }

    public String generateRequest(String[] weapons){
        String display = "Please select";
        for (int counter=0;counter<weapons.length;counter++){
            display += " " + counter + " for " + weapons[counter];
        };
        return display;
    }

    private int requestPlay(String[] weapons)
    {
        return getInteger(generateRequest(weapons));
    }

    public String determineWinner(String[] weaponList, int userWeapon, int computerWeapon, String name)
    {
        String winner;
        if (userWeapon == computerWeapon)
        {
            winner = "Draw both selected " + weaponList[computerWeapon];
        }
        else if ((userWeapon + 1) % 3 == computerWeapon)
        {
            winner = name + " wins and beat the computer's " + weaponList[computerWeapon];
        }
        else if ((computerWeapon + 1) % 3 == userWeapon)
        {
            winner = "Computer wins with " + weaponList[computerWeapon];
        }
        else {
            winner = "Unknown";
        }
        return winner;
    }

    private Map<String, String> getGamesConfiguration(){
        Map<String, String> games = new HashMap<String, String>();
        int gameCounter = 0;
        for (int configCounter = 1; configCounter < this.configuration.size(); configCounter++){
            games.put(this.configuration.get(configCounter).split(":")[0],
                    this.configuration.get(configCounter).split(":")[1]);
        }
        return games;
    }

    public void playGame(String[] weaponList, String name){
        int userWeapon;
        int computerWeapon;
        String winner;
        userWeapon = requestPlay(weaponList);
        do{
            computerWeapon = getComputerChoice();
            winner = determineWinner(weaponList, userWeapon, computerWeapon, name);
            display(winner);
            userWeapon = requestPlay(weaponList);
        } while (userWeapon< weaponList.length);
    }

    private String[] getKeys(Map<String, String> games){
        String[] keys = new String[games.size()];
        int index = 0;
        for (String key : games.keySet()){
            keys[index] = key;
            index++;
        }
        return keys;
    }

    private String[] getWeapons(Map<String, String> games, int game){
        return games.values().toArray()[game].toString().split(",");
    }

    public void run(){
        Map<String, String> gamesConfiguration = getGamesConfiguration();
        String name = getString(QUESTION_WHAT_IS_NAME);
        String[] games = getKeys(gamesConfiguration);
        String gamesRequest = generateRequest(games);
        int userGame = getInteger(gamesRequest);
        while (userGame < this.configuration.size())
        {
            String[] weaponlist = getWeapons(gamesConfiguration, userGame);
            playGame(weaponlist, name);
            userGame = getInteger(gamesRequest);
        } ;
    }

    public static void main(String[ ] args){
        RockPaperScissor rockPaperScissor = new RockPaperScissor();
        rockPaperScissor.run();
    }
}
