import java.util.*;

public class DotCom {
    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> loc) {
        locationCells = (ArrayList<String>) loc.clone();
        for(String a : locationCells){
            System.out.println(" " + a);
        }
        System.out.println("");
    }

    public void setName(String n) {
        name = n;
    }

    public String checkYourself(String userInput) {
        String result = "miss";
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);
            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("You sunk " + name + ": ");
            } else {
                result = "hit";
            }
        }
        return result;
    }
}
