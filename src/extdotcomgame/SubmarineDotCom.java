package extdotcomgame;

public class SubmarineDotCom extends DotCom {
    private boolean underwater = false;
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
            underwater = true;
        } else if(index >= 0 && underwater == true){
            System.out.println(name + " underwater = true");
        }

        if (result == "miss"){
            underwater = false;
        }

        tryguess++;
        return result;
    }

}
