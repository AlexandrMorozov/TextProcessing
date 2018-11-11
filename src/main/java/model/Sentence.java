package model;

import org.apache.log4j.Logger;

import java.util.LinkedHashMap;

public class Sentence
{
    private static final Logger logging =Logger.getLogger(Sentence.class);
    private LinkedHashMap<Integer,Word> listOfWords=new LinkedHashMap<Integer, Word>();
    private LinkedHashMap<Integer,PunctuationMark> listOfSigns=new LinkedHashMap<Integer,PunctuationMark>();
    public LinkedHashMap<Integer, Word> getListOfWords()
    {
        return listOfWords;
    }
    public LinkedHashMap<Integer, PunctuationMark> getListOfSigns()
    {
        return listOfSigns;
    }
    public String assembleSentence(int firstIndex,int lastIndex)
    {
        StringBuilder outputSentence=new StringBuilder();

        for(int j=firstIndex;j<lastIndex;j++)
        {
            if(listOfWords.containsKey(j)==true)
            {
                outputSentence.append(listOfWords.get(j).getWord());
            }
            else if(listOfSigns.containsKey(j)==true)
            {
                outputSentence.append(listOfSigns.get(j).getPunctuationMark());
            }
        }
        return String.valueOf(outputSentence);
    }
    public void swapFirstAndFastWord()
    {
        try
        {
            Integer[] countingBuffer=listOfWords.keySet().toArray(new Integer[listOfWords.size()]);
            Word buffer=listOfWords.get(countingBuffer[0]);
            listOfWords.replace(countingBuffer[0],listOfWords.get(countingBuffer[countingBuffer.length-1]));
            listOfWords.replace(countingBuffer[countingBuffer.length-1],buffer);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            logging.error("Index out of array");
        }

    }
}
