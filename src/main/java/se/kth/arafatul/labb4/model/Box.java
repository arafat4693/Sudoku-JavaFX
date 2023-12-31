package se.kth.arafatul.labb4.model;

import java.io.Serializable;

public class Box implements Serializable {
    private boolean visibility;
    private int correctValue;
    private int userChoice;

    public Box(boolean visibility, int correctValue){
        this.visibility = visibility;
        this.correctValue = correctValue;
    }

    public boolean getVisibility() {
        return visibility;
    }

    public int getCorrectValue() {
        return correctValue;
    }

    public int getUserChoice() {
        return userChoice;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public void setCorrectValue(int correctValue) {
        this.correctValue = correctValue;
    }

    public void setUserChoice(int userChoice) {
        this.userChoice = userChoice;
    }

    @Override
    public String toString() {
        return "Box{" +
                "isVisible=" + visibility +
                ", correctValue=" + correctValue +
                ", userChoice=" + userChoice +
                '}';
    }
}
