package model;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser
{
    private static final Logger logging =Logger.getLogger(Parser.class);
    public Parser(String receivedText,ArrayList<Sentence> listOfSentences)
    {
        parseText(receivedText,listOfSentences);
    }
    public void parseText(String mas,ArrayList<Sentence> listOfSentences)
    {
        Integer indexCounter=0;
        String sentenceParsingPattern="[^\\?\\.\\!\\n]+[\\!\\?\\.\\n][\\s]?";
        Pattern patternInit=Pattern.compile(sentenceParsingPattern);
        Matcher matcher=patternInit.matcher(mas);
        while(matcher.find())
        {
            Sentence currentSentence=new Sentence();
            indexCounter=divideBySpaces(matcher.group(),currentSentence,indexCounter);
            listOfSentences.add(currentSentence);
        }
    }
    private int divideBySpaces(String sentence,Sentence currentSentence,Integer indexCounter)
    {
        int sentenceLength=0;
        for(int u=0;u<sentence.length();u++)
        {
            if(sentence.charAt(u)==' ' || u==sentence.length()-1 )
            {
                try
                {
                    indexCounter=parseIntoWords(sentence.substring(sentenceLength,u+1),currentSentence,indexCounter);
                    indexCounter=parseIntoSigns(sentence.substring(sentenceLength,u+1),currentSentence,indexCounter);
                    sentenceLength=u+1;
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    logging.error("Index out of array");
                }
            }
        }
        return indexCounter;
    }
    private int parseIntoWords(String parsedString,Sentence currentSentence,int indexCounter)
    {
        String pattern="[А-Яа-яA-Za-z\\-]+";
        Pattern patternInit=Pattern.compile(pattern);
        Matcher matcher=patternInit.matcher(parsedString);
        while (matcher.find())
        {
            currentSentence.getListOfWords().put(indexCounter,new Word(matcher.group()));
            indexCounter++;
        }
        return indexCounter;
    }
    private int parseIntoSigns(String parsedString,Sentence sent,int indexCounter)
    {
        String pattern="[–\\s\\:\\.\\?\\!\\,\\…\\«\\»]";
        Pattern patternInit=Pattern.compile(pattern);
        Matcher matcher=patternInit.matcher(parsedString);
        while (matcher.find())
        {
            sent.getListOfSigns().put(indexCounter,new PunctuationMark(matcher.group().charAt(0)));
            indexCounter++;
        }
        return indexCounter;
    }

}
