package extdotcomgame;

import dotcomobservers.Observable;

import java.util.ArrayList;

public class DotCom extends Observable {
    protected ArrayList<String> locationCells;
    public String name;
    private int dotcomsize;

    public void setLocationCells(ArrayList<String> loc) {
        locationCells = (ArrayList<String>) loc.clone();
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getState() {
        return (ArrayList<String>) locationCells.clone();
    }

    public void setSize(int s) {
        dotcomsize = s;
    }

    public int getSize() {
        return dotcomsize;
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
            this.notifyObservers();
        }
        return result;
    }
}
