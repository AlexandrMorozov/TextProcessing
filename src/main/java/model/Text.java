package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Text
{
    private ArrayList<Sentence> listOfSentences=new ArrayList<Sentence>();
    private Parser textParser;
    public void parseText(String text)
    {
        textParser=new Parser(text,listOfSentences);
    }
    public String loadText(String path) throws FileNotFoundException,IOException
    {
        StringBuilder buffer=new StringBuilder();
        File file=new File(path);
        FileReader reader=new FileReader(file);
        Scanner scan=new Scanner(reader);
        while (scan.hasNextLine())
        {
            buffer.append(scan.nextLine());
        }
        reader.close();

        return String.valueOf(buffer);
    }
    public void writeText(String path) throws IOException
    {
        String outputString=createString();
        FileWriter writer=new FileWriter(path);
        writer.write(outputString);
        writer.close();

    }
    private String createString()
    {
        StringBuilder outputText=new StringBuilder();
        int counter=0;
        for(int i=0;i<listOfSentences.size();i++)
        {
            int lastSentenceIndex=listOfSentences.get(i).getListOfWords().size()+listOfSentences.get(i).getListOfSigns().size()+counter;
            outputText.append(listOfSentences.get(i).assembleSentence(counter,lastSentenceIndex));
            counter=lastSentenceIndex;
        }
        return String.valueOf(outputText);
    }

    public ArrayList<Sentence> getListOfSentences()
    {
        return listOfSentences;
    }

    public void SwapWords()
    {
        for(int y=0;y<listOfSentences.size();y++)
        {
            listOfSentences.get(y).swapFirstAndFastWord();
        }
    }


}
