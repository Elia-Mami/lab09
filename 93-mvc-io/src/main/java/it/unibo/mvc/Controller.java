package it.unibo.mvc;

import java.util.ArrayList;

public interface Controller {

    
    void setNextString(String nextString);

    String getNextString();

    ArrayList<String> getStringHistory();

    void printCurrentString();

}