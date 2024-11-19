package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private final static String DEFAULT_NAME = "output";    
    private final static String DEFAULT_PATH = System.getProperty("user.home") 
    + System.getProperty("file.separator")
    + DEFAULT_NAME + ".txt";

    private File currentFile;

    public Controller(){
        this(DEFAULT_PATH);
    } 

    public Controller(String path){
        currentFile = new File(path);
    }

    public File GetCurrentFile(){
        return currentFile;
    }    

    public String GetCurrentFilePath(){
        return currentFile.toPath().toString();
    }    
    
    public void ChangeCurrentFile(final File newCurrentFile){
        currentFile = newCurrentFile;
    }    
    
    public void WriteOnCurrentFile(final String input) throws IOException{
        try(PrintStream ps = new PrintStream(currentFile)){
            ps.println(input);
        }
        catch(IOException e1){
            throw e1;
        }
    }    
}
