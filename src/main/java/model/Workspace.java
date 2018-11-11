package model;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Workspace
{
    private static final Logger logging =Logger.getLogger(Workspace.class);
    private String receivedText;
    private Text currentText;

    public String loadText(String textPath)
    {
        currentText=new Text();
        try
        {
            receivedText=currentText.loadText(textPath);
        }
        catch (FileNotFoundException e)
        {
            logging.error("File not found");
            return "File not found";
        }
        catch (IOException e)
        {
            logging.error("Loading has failed");
            return "Loading has failed";
        }
        return "Text was loaded successfully";
    }
    public void createTextStructure()
    {
        currentText.parseText(receivedText);
    }
    public String writeText(String textPath)
    {
        try
        {
            currentText.writeText(textPath);
        }
        catch (IOException e)
        {
            logging.error("Writing has failed");
            return "Writing has failed";
        }
        return "Text was written successfully";
    }
    public void swapWordsInText()
    {
        currentText.SwapWords();
    }
}
