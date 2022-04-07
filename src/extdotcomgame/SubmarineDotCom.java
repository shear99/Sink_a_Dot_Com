package extdotcomgame;

public class SubmarineDotCom extends DotCom{
    private boolean underwater = true;
    private int tryguess = 0;

    public int size() {
        return 3;
    }

    public String checkYourself(String userInput) {
        String result = "miss";
        int index = locationCells.indexOf(userInput);
        if (index >= 0 && underwater == false) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("You sunk " + name + ": ");
            } else {
                result = "hit";
            }
        }
        tryguess++;
        System.out.println(name + " is underwater!");
        if(tryguess > 10){
            underwater = false;
            System.out.println(name + " is overwater!");
        }
        return result;
    }

}
