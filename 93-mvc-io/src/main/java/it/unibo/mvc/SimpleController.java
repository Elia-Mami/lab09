package it.unibo.mvc;

import java.util.ArrayList;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private ArrayList<String> stringHistory = new ArrayList<>();
    private String nextString;

    @Override
    public void setNextString(String nextString){
        this.nextString = Objects.requireNonNull(nextString, "This method does not accept null values.");
    }

    @Override
    public String getNextString() {
        return this.nextString;
    }

    @Override
    public ArrayList<String> getStringHistory() {
        return this.stringHistory;    
    }

    @Override
    public void printCurrentString() {
        if(this.nextString == null){
            throw new IllegalArgumentException("There is no string");
        }   
        this.stringHistory.add(this.nextString);
    }
}
